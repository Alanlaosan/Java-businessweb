package com.neuedu.entity;

import java.util.List;
/**
 * ��ҳģ��ʵ����
 * javabean
 * */
public class PageFind<T> {

	//��ǰҳ������ݼ���
	private List<T> data;
	//�ܵ�ҳ��
	private int totalpage;
	//��ǰҳ��
	private int currentpage;
	
	
	
	public PageFind() {
		super();
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
}
