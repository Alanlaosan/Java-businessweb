package com.neuedu.service;

public interface OrderService {

	/**
	 * �û��µ�
	 * */
	boolean  createOrder();
	
	/**
	 * 
	 * ���ɶ������order_no
	 * */
  long  generateOrderNo();
}
