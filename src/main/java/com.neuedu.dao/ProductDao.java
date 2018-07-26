package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;

public interface ProductDao {

	 /**
	  * 添加商品
	  * */
	boolean  addProduct(Product product);
	/**
	 * 查看商品
	 * */
	List<Product> findAll();
	/*
	 * 通过fastjson
	 * */
	String findAllByJson();
	/**
	 * 修改商品
	 * */
	boolean  updateProduct(Product product);
	/**
	 * 删除商品
	 * */
	boolean  deleteProduct(int id);
	
	/**根据id查询商品*/
	Product  findById(int id);
	
	/**
	 * 分页获取参数
	 *  pageNo:获取第几页                pageSize：每页有几条数据
	 * */
	
	public PageFind<Product> findProductPage(int pageNo, int pageSize);
	
	/**
	 * 分页第二种
	 * */
	
	
}
