package com.one.longshine.web.action;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.entity.UserFinancalInfo;
import com.one.longshine.form.UserFinancalForm;
import com.one.longshine.service.UserFinancalService;
import com.one.longshine.service.impl.UserFinancalServiceImpl;
/**
 * 账务信息类的修改操作与信息获取
 * @author Administrator
 *
 */
public class UserFinancalAction extends DispatchAction{
	
	/**
	 * 更新账务信息
	 */
	public ActionForward updateUserFinancal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
			//获得对应的form对象
			UserFinancalForm frm =(UserFinancalForm) form;
			
			//获得该用户档案对象
			UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
			//封装ChangeRecord对象
			ChangeRecord cgr = frm.getChangeRecord();
			cgr.setcTable("user_financal_info");
			cgr.setHandleTime(new Date());
			cgr.setHandler("小小");
			cgr.setUserFile(ufi);
			cgr.setcTableSerialId(frm.getChangeRecord().getcTableSerialId());
		
			
			//更新操作
			UserFinancalService ufns = new UserFinancalServiceImpl();
			boolean b = ufns.updateFinancal(frm.getChangeRecord().getcTableSerialId(), cgr); 
			
			//更新成功跳转回用户账务信息列表
			if(b){
				request.setAttribute("message", "更新账务信息成功！");
				return mapping.findForward("updateSuccess");
			}
			else{
				request.setAttribute("message", "更新账务信息失败！");
				
				return mapping.findForward("error");
			}
	}
	/**
	 * 修改开户行前搜索该账户资料
	 */
	public ActionForward getUserFinancalByBank(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//获得该特定账务
		String fi = (String)request.getParameter("fid");
		int fid = Integer.parseInt(fi);
		UserFinancalService ufns = new UserFinancalServiceImpl();
		UserFinancalInfo ufn = ufns.searchByFinancalserialid(fid);
		
		//将该条账务信息存入request
		request.setAttribute("ufn", ufn);
		
		//跳转到修改开户行界面
		return mapping.findForward("getByBankSuccess");
	}
	/**
	 * 修改账号前搜索该账户资料
	 */
	public ActionForward getUserFinancalByAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//获得该账务
		String fid = (String)request.getParameter("fid");
		int fi = Integer.parseInt(fid);
		UserFinancalService ufns = new UserFinancalServiceImpl();
		UserFinancalInfo ufn = ufns.searchByFinancalserialid(fi);
		
		//将该条账务信息存入request
		request.setAttribute("ufn", ufn);
		
		//跳转到修改开户行界面
		return mapping.findForward("getByAccountSuccess");
	}
}
