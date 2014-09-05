package com.one.longshine.entity;

import java.util.List;

/**
 * 实体类：  用来分页
 * 封装分页的信息
 * 
 *  currPage  in  number,  当前页
    pageSize  in  number,  每页显示
    pageCount out  number, 总页数
    rowsCount out   number, 总记录数
    sr out sys_refcursor  查询结果
 * 
 * @author 
 * @version
 */
public class ChangeRecordFenye {
	private  int currPage;
	private  int pageSize;
	private  int pageCount;
	private  int rowsCount;
	private  List<ChangeRecord> changeRecordlist;
	
	public ChangeRecordFenye(){
		
	}
	
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

	public List<ChangeRecord> getChangeRecordlist() {
		return changeRecordlist;
	}

	public void setChangeRecordlist(List<ChangeRecord> changeRecordlist) {
		this.changeRecordlist = changeRecordlist;
	}
	
	
	
	

}
