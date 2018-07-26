package com.neuedu.utils;

import java.util.Scanner;

import com.neuedu.entity.Cart;
import com.neuedu.entity.UserOrderItem;

/**
 * 
 * ��װͨ�õķ���
 * */
public class Utils {
	
	
	
	/**
	  ���ռ�������
	*/
	public static String  input(String msg){
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		return mScanner.nextLine();
	}
	
	
	public  static  int  inputInt(String  msg){
		
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		int operation=mScanner.nextInt();
		return operation;
	}
	
	public  static  double  inputDouble(String  msg){
		
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		double operation=mScanner.nextDouble();
		return operation;
	}
	
	/**
	 * �����ﳵʵ����ת�ɶ�����ϸʵ����
	 * @param id  ������ϸ�����id
	 * @param order_no  �������
	 * @param  cart ���ﳵ����
	 * */
	public static  UserOrderItem convertToOrderItem(int  id,long  order_no,Cart cart) {
		UserOrderItem orderItem=new UserOrderItem();
		orderItem.setId(id);
		
		orderItem.setOrder_no(order_no);
		orderItem.setProduct_id(cart.getProduct().getId());
		orderItem.setProduct_name(cart.getProduct().getName());
		orderItem.setProduct_image(cart.getProduct().getImage());
		orderItem.setCurrent_unit_price(cart.getProduct().getPrice());
		orderItem.setQuantity(cart.getProductNum());
		orderItem.setTotal_price(cart.getProduct().getPrice()*cart.getProductNum());
		orderItem.setCreate_time(System.currentTimeMillis());
		
		return orderItem;
	}

}
