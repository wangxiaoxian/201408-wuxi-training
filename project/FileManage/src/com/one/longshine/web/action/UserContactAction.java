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
 * �����û���ϵ��ʽ����ϵ��ʽ�Ļ�ȡ
 * @author Administrator
 *
 */
public class UserContactAction extends DispatchAction {
	/**
	 * ������ϵ��Ϣ
	 */
	public ActionForward updateContact(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		//���form
		ContactForm frm =(ContactForm) form;
		
		//����û�����
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//��װChangeRecord����
		ChangeRecord cgr = frm.getCr();
		cgr.setcTable("user_contact_info");
		cgr.setHandleTime(new Date());
		cgr.setHandler("���");
		cgr.setUserFile(ufi);
		cgr.setcTableSerialId(frm.getCr().getcTableSerialId());
		
		
		//����
		UserContactService ucs = new UserContactServiceImpl();
		boolean b = ucs.updateContact(frm.getCr().getcTableSerialId(), cgr);
		//��ת����ϵ�б�
		if(b){
			request.setAttribute("message", "���³ɹ���");
			return mapping.findForward("updateSuccess");
		}
		else{
			request.setAttribute("message", "����ʧ�ܣ�");
			return mapping.findForward("error");
		}
	}
	/**
	 * �޸���ϵ��ʽǰ��������ϵ����
	 */
	public ActionForward getContactByType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//��ø���ϵ��ϢID
		String ci = (String)request.getParameter("cid");
		int cid = Integer.parseInt(ci);
		
		//�����ϵ��Ϣ����
		UserContactService ucs = new UserContactServiceImpl();
		UserContactInfo uci = ucs.searchByContactserialid(cid);
		
		//����request��
		request.setAttribute("uci", uci);
		
		//��ת����ϵ��ʽ����
		return mapping.findForward("getByTypeSuccess");
	}
	/**
	 * �޸���ϵ����ǰ��������ϵ����
	 */
	public ActionForward getContactByDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//��ø���ϵID
		String cid = (String)request.getParameter("cid");
		int ci = Integer.parseInt(cid);
		
		//��ø���ϵ��Ϣ�Ķ���
		UserContactService ucs = new UserContactServiceImpl();
		UserContactInfo uci = ucs.searchByContactserialid(ci);
		
		//����request
		request.setAttribute("uci", uci);
		
		//��ת���޸���ϵ����
		return mapping.findForward("getByDetailSuccess");
	}
}
