package com.one.longshine.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.AddFinancalForm;
import com.one.longshine.service.UserFinancalService;
import com.one.longshine.service.impl.UserFinancalServiceImpl;

public class AddFinancalAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//���form����
		AddFinancalForm aff = (AddFinancalForm)form;
		
		//����û�����
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//��ȡ���ӵĿ����к��˺�
		String bank = aff.getOpeningBank();
		String account = aff.getAccount();
		
		//���Ը���Ϣ�治����
		UserFinancalService ufs = new UserFinancalServiceImpl();
		if(ufs.searchByBankAccount(bank, account)){
			request.setAttribute("message", "���ʧ�ܣ���������Ϣ�Ѵ��ڣ�");
			return mapping.findForward("error");
		}
		//����
		
		boolean b = ufs.addFinancal(ufi.getUserSerialId(), bank, account);
		if(b){
			request.setAttribute("message", "����������Ϣ�ɹ���");
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("message", "����������Ϣʧ�ܣ�");
			
			return mapping.findForward("error");
		}
	}
}
