package com.neuedu.data;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public class DataSource {

	//定义商品集合
	public static List<Product> products=new ArrayList<Product>();
	//购物车集合
	public  static List<Cart> carts=new ArrayList<Cart>();
	
	//我的订单集合
	public  static  List<UserOrder> orders=new ArrayList<UserOrder>();
	//订单明细结合
	public  static  List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
	
	
	
	
	
}
