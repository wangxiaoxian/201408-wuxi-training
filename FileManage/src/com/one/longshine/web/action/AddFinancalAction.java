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
		//获得form对象
		AddFinancalForm aff = (AddFinancalForm)form;
		
		//获得用户对象
		UserFileInfo ufi = (UserFileInfo)request.getSession().getAttribute("ufi");
		
		//获取增加的开户行和账号
		String bank = aff.getOpeningBank();
		String account = aff.getAccount();
		
		//测试该信息存不存在
		UserFinancalService ufs = new UserFinancalServiceImpl();
		if(ufs.searchByBankAccount(bank, account)){
			request.setAttribute("message", "添加失败！该账务信息已存在！");
			return mapping.findForward("error");
		}
		//增加
		
		boolean b = ufs.addFinancal(ufi.getUserSerialId(), bank, account);
		if(b){
			request.setAttribute("message", "增加账务信息成功！");
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("message", "增加账务信息失败！");
			
			return mapping.findForward("error");
		}
	}
}
