package com.one.longshine.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.AddContactForm;
import com.one.longshine.service.UserContactService;
import com.one.longshine.service.impl.UserContactServiceImpl;

public class AddContactAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获得form
		AddContactForm acf = (AddContactForm)form;
		
		//获得联系方式，联系内容
		String type = acf.getContactType();
		String detail = acf.getContactDetails();
		
		//测试该信息存不存在
		UserContactService ucs = new UserContactServiceImpl();
		if(ucs.searchByTypeDetail(type, detail)){
			request.setAttribute("message", "添加失败！该联系信息已存在！");
			return mapping.findForward("error");
		}
		
		//获得用户对象
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//增加
		boolean b = ucs.addContact(ufi.getUserSerialId(), type, detail);
		if(b){
			request.setAttribute("message", "添加成功！");
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("message", "添加失败！");
			return mapping.findForward("error");
		}
		
	}
}
