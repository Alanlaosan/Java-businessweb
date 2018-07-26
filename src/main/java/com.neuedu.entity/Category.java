package com.neuedu.entity;

import java.io.Serializable;

//public class CateGory {
//	private String name;
//	private String desc;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDesc() {
//		return desc;
//	}
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
public class Category implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6074164784883227128L;
	private int id;// �������
	private String name;// �������
	private String desc;// �������
	private  int  stock;//���

	

	public Category() {
		super();
	}

	public Category(int id ,String name, String desc,int stock) {
		super();

		this.id=id;
		this.name = name;
		this.desc = desc;
		this.stock = stock;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ",name=" + name + ", desc=" + desc + ",stock="+stock+"]";
	}

}
