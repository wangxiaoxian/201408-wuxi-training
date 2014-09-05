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
		//����û���ˮ��
		String id = request.getParameter("uid");
		int uid = 0;
		if(null!=id){
			uid = Integer.parseInt(id); 
		}else{
			UserFileInfo ufi  = (UserFileInfo)request.getSession().getAttribute("ufi");
			uid = ufi.getUserSerialId();
		} 
		
		//����û�����
		UserFileService ufs = new UserFileServiceImpl();
		UserFileInfo ufi = ufs.searchByUserSerialId(uid);
		
		//����û����е���ϵ��ʽ�б�
		UserContactService ucs = new UserContactServiceImpl();
		List<UserContactInfo> list = ucs.searchByUserSerialId(uid);
		
		//����session���󣬽��û�����Ž�session��
		HttpSession s =request.getSession();
		s.setAttribute("ufi", ufi);
		
		//��ϵ��ʽ�б����request��
		request.setAttribute("list", list);
		
		if(null==list)
			return mapping.findForward("error");
		//��ת���б�ҳ��
		return mapping.findForward("success");
	}
}
