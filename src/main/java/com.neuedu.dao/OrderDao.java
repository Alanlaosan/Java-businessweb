package com.neuedu.dao;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	/**
	 * ��������
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * ���ɶ���id
    * */
   int  generateOrderId();
	
}
