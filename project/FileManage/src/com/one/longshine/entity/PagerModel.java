package com.one.longshine.entity;

import java.util.List;

/**
 * ����һ����ҳ��������Ϣ
 * @author Administrator
 *
 * @param <T> �÷�ҳ���Ա������������
 */
public class PagerModel<T> {

	private  int currPage;// ��ǰҳ��
	private  int recodeNo;//�ڼ�����¼
	private  int pageSize;//��ҳ��С
	private  int pageCount;//��ҳ��
	private  int rowsCount;//�ܼ�¼��
	private  List<T> datas;//���������
	
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
