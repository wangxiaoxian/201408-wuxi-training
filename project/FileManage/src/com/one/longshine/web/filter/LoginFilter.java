package com.one.longshine.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.one.longshine.web.util.StringUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {


	/**
	 * 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// place your code here

		HttpServletRequest request= (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		HttpSession session= request.getSession();
		
		String url= request.getServletPath();
		url = StringUtils.trimStringNotNull(url);

		// ·���а���log������½��Ϣ�����򲻴���
		if(url.toLowerCase().indexOf("login") != -1){
			chain.doFilter(request, response);
//			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else if(session.getAttribute("mgr")==null){
			// �����������Ҫ���е�½��֤�����session
			response.sendRedirect("login.do?method=toLogin");
			return;
		} 
		
		// �����������������������ִ��
		chain.doFilter(request, response);
	}

	/**
	 * 
	 */
	public void destroy() {
		
	}
}
