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
	 * ActionServlet调用该方法
	 */
	public ActionForward login(ActionMapping mapping, // 通过映射文件 找到视图
			ActionForm form, // 封装的表单对象
			HttpServletRequest request, // 请求
			HttpServletResponse response)// 响应
			throws Exception {

		LoginForm loginForm = (LoginForm) form;

		ManagerService mgrService = new ManagerServiceImpl();
		
		boolean isLogin = mgrService.login(loginForm.getUserName(), loginForm.getPassword());
		
		if (isLogin) {
			Manager mgr = new Manager();
			mgr.setUserName(loginForm.getUserName());
			mgr.setPassword(loginForm.getPassword());
			
			request.getSession().setAttribute("mgr", mgr);
			request.setAttribute("msg", "登录成功");
			return mapping.findForward("toMain");
		}
		else{
			request.setAttribute("msg", "用户名或密码错误！！");
			return mapping.findForward("toLogin");
		}
		
	}
	
	public ActionForward toLogin(ActionMapping mapping, // 通过映射文件 找到视图
			ActionForm form, // 封装的表单对象
			HttpServletRequest request, // 请求
			HttpServletResponse response)// 响应
			throws Exception {
		request.getSession().removeAttribute("mgr");
		return mapping.findForward("toLogin");
	}
}
