package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;

/**
 * 
 * 
 * 购物车
 * */
public interface CartDao {

	/**
	 * 添加购物车
	 **/
	boolean  addCart(Cart cart);
	/**
	 * 删除购物信息的Id
	 * */
	boolean  deleteCart(int id);
	/**
	 * 修改购物车
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * 查询购物车
	 * */
	List<Cart> findAllCart();
	
	/**
	 * 获取购物车中商品数量
	 * */
	int  getCartNum();
	
	/**修改购物车商品数量
	 * @param  id  要修改的商品的Id
	 * @param  num 修改后的数量
	 * */
	boolean updateCart(int id, int num);
	

	/**
	 * 清空购物车
	 * */
	void  clearCart() ;
	
	/**
	 * 分页获取参数
	 *  pageNo:获取第几页                pageSize：每页有几条数据
	 * */
	
	/**根据id查询商品*/
	Cart  findById(int id);
	
	public PageFind<Cart> findCartPage(int pageNo, int pageSize);

	
}
