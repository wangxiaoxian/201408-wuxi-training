package com.one.longshine.entity;

import java.util.List;

/**
 * ʵ���ࣺ  ������ҳ
 * ��װ��ҳ����Ϣ
 * 
 *  currPage  in  number,  ��ǰҳ
    pageSize  in  number,  ÿҳ��ʾ
    pageCount out  number, ��ҳ��
    rowsCount out   number, �ܼ�¼��
    sr out sys_refcursor  ��ѯ���
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
