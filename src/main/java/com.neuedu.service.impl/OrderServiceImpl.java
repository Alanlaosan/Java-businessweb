package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.dao.impl.jdbc.OrderDaoImpl;
import com.neuedu.dao.impl.jdbc.OrderItemDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;

public class OrderServiceImpl implements OrderService {

	CartDao cartDao=new CartDaoImpl();
	OrderDao orderDao=new OrderDaoImpl();
	OrderItemDao orderItemDao=new OrderItemDaoImpl();
	@Override
	public boolean createOrder() {
		// TODO Auto-generated method stub
		
		//step1:��ȡ���ﳵ�еĹ�����Ϣ  List<Cart>
		List<Cart> carts= cartDao.findAllCart();
		 if(carts==null||carts.size()<=0) {
			 return false;
		 }
		//step2:���ɶ���ʵ���� UserOrder
		   UserOrder   userOrder=createUserOrder();
		   
		//step3:��������Ϣ����ת�ɶ�����ϸ����List<UserOrderItem>
		  List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
 		   for(int i=0;i<carts.size();i++) {
 			   Cart cart=carts.get(i);
 			   UserOrderItem orderItem= Utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
 			   
 			  //step4:������
 			   if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
 				   //������
 				  orderItems.add(orderItem);
 			   }else {//��治��
 				  return false;  
 			   }
 			   
 			   
 		   }
		 //step5:���㶩���۸�
 		   userOrder.setPayment(getOrderPrice(orderItems));
		//step5:�µ�
 		   orderDao.createOrder(userOrder);
 		   orderItemDao.addOrderItems(orderItems);
 		
		//step6:�ۿ��
		
 		   for(int  i=0;i<carts.size();i++) {
 			   Cart cart=carts.get(i);
 			   Product product=cart.getProduct();
 			   int leftStock=product.getStock()-cart.getProductNum();
 			   product.setStock(leftStock);
 		   }
 		   
		//step7:��չ��ﳵ
		
		cartDao.clearCart();
		
		
		
		
		return true;
	}
	
	
	/**
	 * ���ɶ�������
	 * */
	public  UserOrder createUserOrder() {
		
		UserOrder order=new UserOrder();
		//���ö���id
		order.setId(orderDao.generateOrderId());
		// 1s=1000ms  1970 1.1 - ��ǰ
		order.setOrder_no(generateOrderNo());
		order.setCreate_time(System.currentTimeMillis());
		
		return order;
	}

	/**
	 * ���ɶ�����
	 * */
	
	@Override
	public long generateOrderNo() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
	/**
	 * ���㶩���۸�
	 * */
	public  double  getOrderPrice(List<UserOrderItem> items) {
		double  totalPrice=0.0;
		for(int i=0;i<items.size();i++) {
			totalPrice+=items.get(i).getTotal_price();
		}
		return  totalPrice;
	}
	

}
