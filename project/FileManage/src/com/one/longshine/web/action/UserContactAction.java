package com.one.longshine.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserContactInfo;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.ContactForm;
import com.one.longshine.service.UserContactService;
import com.one.longshine.service.UserFileService;
import com.one.longshine.service.impl.UserContactServiceImpl;
import com.one.longshine.service.impl.UserFileServiceImpl;
/**
 * 更新用户联系方式与联系方式的获取
 * @author Administrator
 *
 */
public class UserContactAction extends DispatchAction {
	/**
	 * 更新联系信息
	 */
	public ActionForward updateContact(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		//获得form
		ContactForm frm =(ContactForm) form;
		
		//获得用户对象
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//封装ChangeRecord对象
		ChangeRecord cgr = frm.getCr();
		cgr.setcTable("user_contact_info");
		cgr.setHandleTime(new Date());
		cgr.setHandler("大大");
		cgr.setUserFile(ufi);
		cgr.setcTableSerialId(frm.getCr().getcTableSerialId());
		
		
		//更新
		UserContactService ucs = new UserContactServiceImpl();
		boolean b = ucs.updateContact(frm.getCr().getcTableSerialId(), cgr);
		//跳转回联系列表
		if(b){
			request.setAttribute("message", "更新成功！");
			return mapping.findForward("updateSuccess");
		}
		else{
			request.setAttribute("message", "更新失败！");
			return mapping.findForward("error");
		}
	}
	/**
	 * 修改联系方式前搜索该联系资料
	 */
	public ActionForward getContactByType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//获得该联系信息ID
		String ci = (String)request.getParameter("cid");
		int cid = Integer.parseInt(ci);
		
		//获得联系信息对象
		UserContactService ucs = new UserContactServiceImpl();
		UserContactInfo uci = ucs.searchByContactserialid(cid);
		
		//存入request中
		request.setAttribute("uci", uci);
		
		//跳转到联系方式界面
		return mapping.findForward("getByTypeSuccess");
	}
	/**
	 * 修改联系内容前搜索该联系资料
	 */
	public ActionForward getContactByDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//获得该联系ID
		String cid = (String)request.getParameter("cid");
		int ci = Integer.parseInt(cid);
		
		//获得该联系信息的对象
		UserContactService ucs = new UserContactServiceImpl();
		UserContactInfo uci = ucs.searchByContactserialid(ci);
		
		//存入request
		request.setAttribute("uci", uci);
		
		//跳转到修改联系内容
		return mapping.findForward("getByDetailSuccess");
	}
}
