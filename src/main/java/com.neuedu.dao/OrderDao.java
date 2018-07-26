package com.neuedu.dao;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	/**
	 * 创建订单
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * 生成订单id
    * */
   int  generateOrderId();
	
}
