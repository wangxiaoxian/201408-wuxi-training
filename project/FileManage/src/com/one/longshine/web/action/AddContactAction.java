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
		//���form
		AddContactForm acf = (AddContactForm)form;
		
		//�����ϵ��ʽ����ϵ����
		String type = acf.getContactType();
		String detail = acf.getContactDetails();
		
		//���Ը���Ϣ�治����
		UserContactService ucs = new UserContactServiceImpl();
		if(ucs.searchByTypeDetail(type, detail)){
			request.setAttribute("message", "���ʧ�ܣ�����ϵ��Ϣ�Ѵ��ڣ�");
			return mapping.findForward("error");
		}
		
		//����û�����
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//����
		boolean b = ucs.addContact(ufi.getUserSerialId(), type, detail);
		if(b){
			request.setAttribute("message", "��ӳɹ���");
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("message", "���ʧ�ܣ�");
			return mapping.findForward("error");
		}
		
	}
}
