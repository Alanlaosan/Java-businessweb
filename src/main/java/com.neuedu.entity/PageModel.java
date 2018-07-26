package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;
/**
 * ��ҳģ��ʵ����
 * javabean
 * */
public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4113185237114627627L;
	//��ǰҳ������ݼ���
	private List<T> data;
	//�ܵ�ҳ��
	private int totalpage;
	//��ǰҳ��
	private int currentpage;
	
	
	public PageModel() {
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
