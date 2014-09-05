package com.one.longshine.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.service.UserContactService;
import com.one.longshine.service.impl.UserContactServiceImpl;

public class DelContactAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("cid");
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		int uid = ufi.getUserSerialId();
		int cid = Integer.parseInt(id);
		UserContactService ucs = new UserContactServiceImpl();
		boolean flag = ucs.delContact(cid, uid);
		if(flag){
			request.setAttribute("message", "É¾³ý"+"³É¹¦£¡");
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			return mapping.findForward("error");
		}
	}
}
