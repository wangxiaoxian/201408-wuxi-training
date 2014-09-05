package com.one.longshine.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.one.longshine.entity.Manager;
import com.one.longshine.form.LoginForm;
import com.one.longshine.service.ManagerService;
import com.one.longshine.service.impl.ManagerServiceImpl;

public class LoginAction extends DispatchAction {

	/**
	 * ActionServlet���ø÷���
	 */
	public ActionForward login(ActionMapping mapping, // ͨ��ӳ���ļ� �ҵ���ͼ
			ActionForm form, // ��װ�ı�����
			HttpServletRequest request, // ����
			HttpServletResponse response)// ��Ӧ
			throws Exception {

		LoginForm loginForm = (LoginForm) form;

		ManagerService mgrService = new ManagerServiceImpl();
		
		boolean isLogin = mgrService.login(loginForm.getUserName(), loginForm.getPassword());
		
		if (isLogin) {
			Manager mgr = new Manager();
			mgr.setUserName(loginForm.getUserName());
			mgr.setPassword(loginForm.getPassword());
			
			request.getSession().setAttribute("mgr", mgr);
			request.setAttribute("msg", "��¼�ɹ�");
			return mapping.findForward("toMain");
		}
		else{
			request.setAttribute("msg", "�û�����������󣡣�");
			return mapping.findForward("toLogin");
		}
		
	}
	
	public ActionForward toLogin(ActionMapping mapping, // ͨ��ӳ���ļ� �ҵ���ͼ
			ActionForm form, // ��װ�ı�����
			HttpServletRequest request, // ����
			HttpServletResponse response)// ��Ӧ
			throws Exception {
		request.getSession().removeAttribute("mgr");
		return mapping.findForward("toLogin");
	}
}
