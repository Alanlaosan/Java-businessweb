package com.neuedu.dao;

import com.neuedu.entity.UserOrder;

import java.util.List;

public interface OrderDao {

	/**
	 * ��������
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * ���ɶ���id
    * */
   int  generateOrderId();

   /**
    * ���ݶ�����Ų�ѯ����
    * */
   UserOrder findOrderByOrderno(long orderno);
}
