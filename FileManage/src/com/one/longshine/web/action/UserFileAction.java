package com.one.longshine.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.Manager;
import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.ChangeRecordForm;
import com.one.longshine.form.SearchFileForm;
import com.one.longshine.form.UserFileForm;
import com.one.longshine.service.UserFileService;
import com.one.longshine.service.impl.UserFileServiceImpl;
import com.one.longshine.web.util.StringUtils;

/**
 * 
 * @author Administrator
 *
 */
public class UserFileAction extends DispatchAction {

	private UserFileService ufService = new UserFileServiceImpl();
	
	public ActionForward getPagedUserFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SearchFileForm sff = (SearchFileForm) form;
		
		int recordNo = -1;
		int pageSize = 10;
		
		try {
			recordNo = Integer.parseInt(StringUtils.trimString(request.getParameter("recordNo")));
			
			// 页面大小可以由前台传进来
//			pageSize = Integer.parseInt(StringUtils.trimString(request.getParameter("pageSize")));
		} catch (Exception e) {
			recordNo = 0;
			pageSize = 10;
		}
		
		PagerModel<UserFileInfo> ufPager = ufService.getUserFiles(sff, recordNo + 1, pageSize);
		
		request.setAttribute("ufPage", ufPager);
		request.setAttribute("sff", sff);
		
		return mapping.findForward("listPage");
	}
	
	/**
	 * 获取所有的用户档案信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getAllUserFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<UserFileInfo> ufs = ufService.getUserFiles();
		request.setAttribute("ufs", ufs);
		
		return mapping.findForward("list");
	}

	/**
	 * 更改用户档案的 用户名 这一项
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editUserNameInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserFileForm uff = (UserFileForm) form;
		
		UserFileInfo uf = ufService.getUserFile(uff.getUserSerialId());
		
		request.setAttribute("uf", uf);
		
		return mapping.findForward("editUserName");
	}
	
	/**
	 * 更改用户档案的 地址 这一项
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editUserAddressInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserFileForm uff = (UserFileForm) form;
		
		UserFileInfo uf = ufService.getUserFile(uff.getUserSerialId());
		
		request.setAttribute("uf", uf);
		
		return mapping.findForward("editUserAddress");
	}
	
	/**
	 * 所有对用户档案进行的更改都提交到这个方法进行处理
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editUserFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserFileForm uff = (UserFileForm) form;
		
//		Manager mgr = (Manager)request.getSession().getAttribute("mgr");
		
		// 从form当中提取出UserFileInfo对象
		UserFileInfo uf = new UserFileInfo();
		uf.setUserSerialId(uff.getUserSerialId());
		uf.setUserName(uff.getUserName());
		uf.setAddress(uff.getAddress());
		
		// 从form当中提取出ChangeRecord对象
		ChangeRecord cr = new ChangeRecord();
		cr.setUserFile(uf);
		cr.setcTable("userfileinfo");
		cr.setcTableSerialId(uff.getUserSerialId());
		cr.setcField(uff.getField());
		cr.setcBeforeValue(uff.getOldValue());
		cr.setcAfterValue(uff.getUserName());
		cr.setcReason(uff.getReason());
		cr.setcContent(uff.getContent());
//		cr.setHandler(mgr.getUserId() + "");  //添加了业务员的登录功能再打开这个注释
		cr.setHandleTime(new Date());
		
		ufService.editUserFile(uff.getField(), uf, cr);
		
		return mapping.findForward("redList");
	}

	/**
	 * 添加用户档案，输入界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addUserFileInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("addUserFile");
	}
	
	/**
	 * 添加用户档案
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addUserFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserFileForm uff = (UserFileForm) form;
		
//		Manager mgr = (Manager)request.getSession().getAttribute("mgr");
		Manager mgr = new Manager();
		mgr.setUserId(1);
		mgr.setUserName("admin");
		mgr.setPassword("admin");
		
		// 从form当中提取出UserFileInfo对象
		UserFileInfo uf = new UserFileInfo();
		uf.setState("y");
		uf.setAddress(uff.getAddress());
		uf.setUserName(uff.getUserName());
		
		// 从form当中提取出ChangeRecord对象
		ChangeRecord cr = new ChangeRecord();
		cr.setUserFile(uf);
		cr.setcTable("USER_FILE_INFO");
		cr.setcReason(uff.getReason());
		cr.setcContent(uff.getContent());
		cr.setHandler(mgr.getUserId() + "");  
		
		ufService.addUserFile(uf, cr);
		
		return mapping.findForward("redList");
	}
	
	/**
	 * 注销用户
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
		public ActionForward logOff(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
			
			ChangeRecordForm crForm=(ChangeRecordForm)form;
			
			
			request.setAttribute("userSerialId", crForm.getUserSerialId());
			
			return mapping.findForward("addRecord");
			
		}
}
