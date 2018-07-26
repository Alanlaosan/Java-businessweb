package com.neuedu.service;

public interface OrderService {

	/**
	 * 用户下单
	 * */
	boolean  createOrder();
	
	/**
	 * 
	 * 生成订单编号order_no
	 * */
  long  generateOrderNo();
}
