package com.one.longshine.web.util;

public class StringUtils {

	/**
	 * ��strΪnull,�򷵻�null������ȥ��str����β�ո�
	 * @param str
	 * @return
	 */
	public static String trimString(Object str) {
		if (str == null) return null;
		return str.toString().trim();
		
	}
	
	/**
	 * ��strΪnull,���ÿ��ַ������棻����ȥ��str����β�ո�
	 * @param str
	 * @return
	 */
	public static String trimStringNotNull(Object str) {
		if (str == null) {
			str = "";
		}
		return str.toString().trim();
	}
}
