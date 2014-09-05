package com.one.longshine.web.util;

public class StringUtils {

	/**
	 * 若str为null,则返回null；否则去除str的首尾空格。
	 * @param str
	 * @return
	 */
	public static String trimString(Object str) {
		if (str == null) return null;
		return str.toString().trim();
		
	}
	
	/**
	 * 若str为null,则用空字符串代替；否则去除str的首尾空格。
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
