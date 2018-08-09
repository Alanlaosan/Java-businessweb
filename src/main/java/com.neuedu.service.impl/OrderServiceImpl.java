package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
//import com.neuedu.dao.impl.jdbc.CartDaoImpl;
//import com.neuedu.dao.impl.jdbc.OrderDaoImpl;
//import com.neuedu.dao.impl.jdbc.OrderItemDaoImpl;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.dao.impl.jdbc.mybatis.OrderDaoMybatisImpl;
import com.neuedu.dao.impl.jdbc.mybatis.OrderItemDaoMybatisImpl;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;

public class OrderServiceImpl implements OrderService {

	/*CartDao cartDao=new CartDaoImpl();
	OrderDao orderDao=new OrderDaoImpl();
	OrderItemDao orderItemDao=new OrderItemDaoImpl();*/
	CartDao cartDao=new CartDaoMybatisImpl();
	OrderDao orderDao=new OrderDaoMybatisImpl();
	OrderItemDao orderItemDao=new OrderItemDaoMybatisImpl();
	ProductDao productDao = new ProductMybatisDao();
	@Override
	public boolean createOrder() {
		// TODO Auto-generated method stub
		
		//step1:获取购物车中的购物信息  List<Cart>
		List<Cart> carts= cartDao.findAllCart();
		 if(carts==null||carts.size()<=0) {
			 return false;
		 }


		//step2:生成订单实体类 UserOrder
		   UserOrder   userOrder=createUserOrder();
		   
		//step3:将购物信息集合转成订单明细集合List<UserOrderItem>
		  List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
 		   for(int i=0;i<carts.size();i++) {
 			   Cart cart=carts.get(i);
 			   UserOrderItem orderItem= Utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
 			   
 			  //step4:检验库存(修改了2018.07.30，下午老师修改的)
 			   if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
 				   //库存充足
 				  orderItems.add(orderItem);
 			   }else {//库存不足
 				  return false;  
 			   }
 		   }
		 //step5:计算订单价格
 		   userOrder.setPayment(getOrderPrice(orderItems));
		//step5:下单        baocuo已解决createOrder少写一个e
 		   orderDao.createOrder(userOrder);
 		   //baocuo   已解决，product_id属性没加下划线
 		   orderItemDao.addOrderItems(orderItems);
 		
		//step6:扣库存
		
 		   for(int  i=0;i<carts.size();i++) {
 			   Cart cart=carts.get(i);
 			   Product product=cart.getProduct();
 			   int leftStock=product.getStock()-cart.getProductNum();
 			   //修改商品库存
 			   product.setStock(leftStock);
 			   productDao.updateProduct(product);
 		   }
 		   
		//step7:清空购物车
		cartDao.clearCart();

		return true;
	}
	
	
	/**
	 * 生成订单对象
	 * */
	public  UserOrder createUserOrder() {
		
		UserOrder order=new UserOrder();
		//设置订单id,自动增长了，没有必要了
		//order.setId(orderDao.generateOrderId());
		// 1s=1000ms  1970 1.1 - 当前
		order.setOrder_no(generateOrderNo());
		order.setCreate_time(System.currentTimeMillis());
		
		return order;
	}

	/**
	 * 生成订单号
	 * */
	
	@Override
	public long generateOrderNo() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
	/**
	 * 计算订单价格
	 * */
	public  double  getOrderPrice(List<UserOrderItem> items) {
		double  totalPrice=0.0;
		for(int i=0;i<items.size();i++) {
			totalPrice+=items.get(i).getTotal_price();
		}
		return  totalPrice;
	}
	

}
