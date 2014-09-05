package com.one.longshine.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.UserContactInfo;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.service.UserContactService;
import com.one.longshine.service.UserFileService;
import com.one.longshine.service.impl.UserContactServiceImpl;
import com.one.longshine.service.impl.UserFileServiceImpl;

public class ListContactAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获得用户流水号
		String id = request.getParameter("uid");
		int uid = 0;
		if(null!=id){
			uid = Integer.parseInt(id); 
		}else{
			UserFileInfo ufi  = (UserFileInfo)request.getSession().getAttribute("ufi");
			uid = ufi.getUserSerialId();
		} 
		
		//获得用户对象
		UserFileService ufs = new UserFileServiceImpl();
		UserFileInfo ufi = ufs.searchByUserSerialId(uid);
		
		//获得用户所有的联系方式列表
		UserContactService ucs = new UserContactServiceImpl();
		List<UserContactInfo> list = ucs.searchByUserSerialId(uid);
		
		//创建session对象，将用户对象放进session中
		HttpSession s =request.getSession();
		s.setAttribute("ufi", ufi);
		
		//联系方式列表放入request中
		request.setAttribute("list", list);
		
		if(null==list)
			return mapping.findForward("error");
		//跳转到列表页面
		return mapping.findForward("success");
	}
}
