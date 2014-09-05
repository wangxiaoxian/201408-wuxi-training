package com.one.longshine.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;
import com.one.longshine.entity.Manager;
import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.ChangeRecordForm;
import com.one.longshine.form.SearchFileForm;
import com.one.longshine.form.UserFileForm;
import com.one.longshine.service.ChangeRecordService;
import com.one.longshine.service.UserFileService;
import com.one.longshine.service.impl.ChangeRecordServiceImpl;
import com.one.longshine.service.impl.UserFileServiceImpl;
import com.one.longshine.web.util.StringUtils;

/**
 * 
 * @author Administrator
 *
 */
public class ChangeRecordAction extends DispatchAction {

	private ChangeRecordService cRService=new ChangeRecordServiceImpl();
	private UserFileService ufService = new UserFileServiceImpl();
	
	
	//获得变更记录列表
	public ActionForward getChangeRecord(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ChangeRecordForm crForm=(ChangeRecordForm)form;
		ChangeRecordFenye fenye=cRService.getChangeRecords(crForm.getUserId(),crForm.getPage(),10);
		request.setAttribute("countList", fenye.getRowsCount());
		request.setAttribute("changeRecords", fenye);
		
		int [] pages=new int[fenye.getPageCount()];
		for(int i=0;i<pages.length;i++){
			pages[i]=i+1;
		}
		
		//页面分页
		request.setAttribute("pages", pages);
		
		return mapping.findForward("searchRecord");
	}
	
	
	//添加变更记录
		public ActionForward addChangeRecord(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ChangeRecordForm crForm=(ChangeRecordForm)form;
			ChangeRecord cRecord=new ChangeRecord();
			cRecord.setcTable("USER_FILE_INFO");
			
			cRecord.setcTableSerialId(crForm.getUserSerialId());
			UserFileInfo fileInfo=new UserFileInfo();
			fileInfo.setUserSerialId(crForm.getUserSerialId());
			cRecord.setUserFile(fileInfo);
			cRecord.setcField("STATE");
			cRecord.setcBeforeValue(crForm.getcBeforeValue());
			cRecord.setcAfterValue(crForm.getcAfterValue());
			cRecord.setcContent(crForm.getcContent());
			cRecord.setcReason(crForm.getcReason());
			cRecord.setHandler("admin");
			cRecord.setHandleTime(new Date());
			
			
			if(cRService.LogOff(cRecord,crForm.getUserSerialId())){
				if(crForm.getFlag()==1)
					return mapping.findForward("toTab");
					else {
						return mapping.findForward("toListPage");
				}
			}
			else {
				return mapping.findForward("error");
			}
			
		}

}
