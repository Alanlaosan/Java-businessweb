package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;

/**
 * 
 * 
 * ���ﳵ
 * */
public interface CartDao {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��������Ϣ��Id
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
	 * @param  id  Ҫ�޸ĵ���Ʒ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean updateCart(int id, int num);
	

	/**
	 * ��չ��ﳵ
	 * */
	void  clearCart() ;
	
	/**
	 * ��ҳ��ȡ����
	 *  pageNo:��ȡ�ڼ�ҳ                pageSize��ÿҳ�м�������
	 * */
	
	/**����id��ѯ��Ʒ*/
	Cart  findById(int id);
	
	public PageFind<Cart> findCartPage(int pageNo, int pageSize);

	
}
