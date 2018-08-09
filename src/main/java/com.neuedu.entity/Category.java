package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;


public class Category implements Serializable {


	private static final long serialVersionUID = -6074164784883227128L;
	private int id;// 类别名称
	/*private int parents_id;//父类id*/
	private String name;// 类别名称
	private String desc;// 类别描述
	/*private long create_time;
	private long update_time;
	private Product product;*/
	private  int  stock;//库存

	

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
	public Category(String name, String desc,int stock) {
		super();
		
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
