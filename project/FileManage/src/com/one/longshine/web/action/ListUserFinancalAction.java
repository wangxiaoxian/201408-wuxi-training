package com.one.longshine.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.entity.UserFinancalInfo;
import com.one.longshine.service.UserFileService;
import com.one.longshine.service.UserFinancalService;
import com.one.longshine.service.impl.UserFileServiceImpl;
import com.one.longshine.service.impl.UserFinancalServiceImpl;
/**
 * 获得用户所属的账务信息列表
 * 跳转到账务列表页面，维护用户session对象
 * @author Administrator
 *
 */
public class ListUserFinancalAction extends Action{
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
			//通过用户流水号找到用户档案
			UserFileService ufs = new UserFileServiceImpl();
			UserFileInfo ufi = ufs.searchByUserSerialId(uid);
			
			//通过用户流水号找到所属的账务信息列表
			UserFinancalService ufns = new UserFinancalServiceImpl();
			List<UserFinancalInfo> list = ufns.searchByUserSerialId(uid);
			
			//创建session对象，将用户对象放进session中
			HttpSession s =request.getSession();
			s.setAttribute("ufi", ufi);
			
			//账务信息列表放入request中
			request.setAttribute("list", list);
			
			if(null==list)
				return mapping.findForward("error");
			//跳转到用户所有的账务信息列表
			return mapping.findForward("success");
	}
}
