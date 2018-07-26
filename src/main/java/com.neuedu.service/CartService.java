package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;

public interface CartService {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��
	 * */
	boolean  deleteCart(int id);
	/**
	 * �޸Ĺ��ﳵ
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * ��ѯ���ﳵ
	 * */
	List<Cart> findAllCart();
	
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	int  getCartNum();
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);
	
	 /**����id��ѯ���ﳵ��Ϣ*/
    Cart  findCartById(int id);
	
	 /*��ҳ��ѯ*/
    public PageFind<Cart> findCartByPage(Integer pageNo, Integer pageSize);
}
