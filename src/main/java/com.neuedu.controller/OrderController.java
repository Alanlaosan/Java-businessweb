package com.neuedu.controller;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

public class OrderController {

	OrderService orderService=new OrderServiceImpl();
	
	public  boolean  createOrder() {
		
		return orderService.createOrder();
		
	}
	
	
}
