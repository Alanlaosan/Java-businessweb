package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  Product  product;
	private int productid;
	private  int  productnum;//商品数量
	public Cart(int id,int productid, int productnum, Product  product) {
		super();
		this.id = id;
		this.productnum = productnum;
		this.productid = productid;
		this.product=product;
	}
	public Cart(int id,int productid, int productnum) {
		super();
		this.id = id;
		this.productnum = productnum;
		this.productid = productid;

	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getProductNum() {
		return productnum;
	}
	public void setProductNum(int productNum) {
		this.productnum = productNum;
	}
	@Override

	/*public String toString() {
		return "Cart [id=" + id + ", productid=" + productid + ", productNum=" + productnum + "]";
	}*/

	
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", product=" + product +
				", productid=" + productid +
				", productnum=" + productnum +
				'}';
	}
}
