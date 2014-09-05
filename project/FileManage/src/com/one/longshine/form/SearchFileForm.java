package com.one.longshine.form;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.struts.action.ActionForm;

import com.one.longshine.web.util.StringUtils;

/**
 * 主要用于用户档案的查询
 * @author Administrator
 *
 */
public class SearchFileForm extends ActionForm {

	private static final long serialVersionUID = -5766125540928048701L;

	private String userId;
	private String userName;
	
	public SearchFileForm() {
		this.userId = "";
		this.userName = "";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = StringUtils.trimStringNotNull(userId);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		try {
			userName = URLEncoder.encode(userName, "iso8859-1");
			userName = URLDecoder.decode(URLDecoder.decode(userName, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		this.userName = StringUtils.trimStringNotNull(userName);
	}
}
