package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 分页模型实体类
 * javabean
 * */
public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4113185237114627627L;
	//当前页面的数据集合
	private List<T> data;
	//总的页数
	private int totalpage;
	//当前页面
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
