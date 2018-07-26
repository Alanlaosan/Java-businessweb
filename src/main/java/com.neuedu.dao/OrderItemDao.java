package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;

public interface OrderItemDao {

	/**
	 * 将订单下的订单明细添加到订单明细集合中
	 * */
	 boolean  addOrderItems(List<UserOrderItem> orederItems);
	
	 /**
	  * 生成订单明细id
	  * */
	 
	 int  generateOrderItemId();
}
