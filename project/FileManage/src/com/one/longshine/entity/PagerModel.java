package com.one.longshine.entity;

import java.util.List;

/**
 * 保存一个分页的所有信息
 * @author Administrator
 *
 * @param <T> 该分页可以保存的数据类型
 */
public class PagerModel<T> {

	private  int currPage;// 当前页码
	private  int recodeNo;//第几条记录
	private  int pageSize;//分页大小
	private  int pageCount;//总页数
	private  int rowsCount;//总记录数
	private  List<T> datas;//保存的数据
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getRecodeNo() {
		return recodeNo;
	}
	public void setRecodeNo(int recodeNo) {
		this.recodeNo = recodeNo;
	}
}
