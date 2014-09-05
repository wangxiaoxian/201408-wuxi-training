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
 * ������Ϣ����޸Ĳ�������Ϣ��ȡ
 * @author Administrator
 *
 */
public class UserFinancalAction extends DispatchAction{
	
	/**
	 * ����������Ϣ
	 */
	public ActionForward updateUserFinancal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
			//��ö�Ӧ��form����
			UserFinancalForm frm =(UserFinancalForm) form;
			
			//��ø��û���������
			UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
			//��װChangeRecord����
			ChangeRecord cgr = frm.getChangeRecord();
			cgr.setcTable("user_financal_info");
			cgr.setHandleTime(new Date());
			cgr.setHandler("СС");
			cgr.setUserFile(ufi);
			cgr.setcTableSerialId(frm.getChangeRecord().getcTableSerialId());
		
			
			//���²���
			UserFinancalService ufns = new UserFinancalServiceImpl();
			boolean b = ufns.updateFinancal(frm.getChangeRecord().getcTableSerialId(), cgr); 
			
			//���³ɹ���ת���û�������Ϣ�б�
			if(b){
				request.setAttribute("message", "����������Ϣ�ɹ���");
				return mapping.findForward("updateSuccess");
			}
			else{
				request.setAttribute("message", "����������Ϣʧ�ܣ�");
				
				return mapping.findForward("error");
			}
	}
	/**
	 * �޸Ŀ�����ǰ�������˻�����
	 */
	public ActionForward getUserFinancalByBank(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//��ø��ض�����
		String fi = (String)request.getParameter("fid");
		int fid = Integer.parseInt(fi);
		UserFinancalService ufns = new UserFinancalServiceImpl();
		UserFinancalInfo ufn = ufns.searchByFinancalserialid(fid);
		
		//������������Ϣ����request
		request.setAttribute("ufn", ufn);
		
		//��ת���޸Ŀ����н���
		return mapping.findForward("getByBankSuccess");
	}
	/**
	 * �޸��˺�ǰ�������˻�����
	 */
	public ActionForward getUserFinancalByAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		//��ø�����
		String fid = (String)request.getParameter("fid");
		int fi = Integer.parseInt(fid);
		UserFinancalService ufns = new UserFinancalServiceImpl();
		UserFinancalInfo ufn = ufns.searchByFinancalserialid(fi);
		
		//������������Ϣ����request
		request.setAttribute("ufn", ufn);
		
		//��ת���޸Ŀ����н���
		return mapping.findForward("getByAccountSuccess");
	}
}
