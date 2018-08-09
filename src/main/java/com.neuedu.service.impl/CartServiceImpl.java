package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao/*=new CartDaoImpl()*/;
	//CartDao cartDao = new CartDaoMybatisImpl();


	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updataeCart(cart);
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public PageFind<Cart> findCartByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return cartDao.findCartPage(pageNo, pageSize);
	}

	@Override
	public Cart findCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findById(id);
	}

}
