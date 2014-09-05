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
 * ����û�������������Ϣ�б�
 * ��ת�������б�ҳ�棬ά���û�session����
 * @author Administrator
 *
 */
public class ListUserFinancalAction extends Action{
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
			//ͨ���û���ˮ���ҵ��û�����
			UserFileService ufs = new UserFileServiceImpl();
			UserFileInfo ufi = ufs.searchByUserSerialId(uid);
			
			//ͨ���û���ˮ���ҵ�������������Ϣ�б�
			UserFinancalService ufns = new UserFinancalServiceImpl();
			List<UserFinancalInfo> list = ufns.searchByUserSerialId(uid);
			
			//����session���󣬽��û�����Ž�session��
			HttpSession s =request.getSession();
			s.setAttribute("ufi", ufi);
			
			//������Ϣ�б����request��
			request.setAttribute("list", list);
			
			if(null==list)
				return mapping.findForward("error");
			//��ת���û����е�������Ϣ�б�
			return mapping.findForward("success");
	}
}
