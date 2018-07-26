package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;

public interface ProductDao {

	 /**
	  * �����Ʒ
	  * */
	boolean  addProduct(Product product);
	/**
	 * �鿴��Ʒ
	 * */
	List<Product> findAll();
	/*
	 * ͨ��fastjson
	 * */
	String findAllByJson();
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateProduct(Product product);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteProduct(int id);
	
	/**����id��ѯ��Ʒ*/
	Product  findById(int id);
	
	/**
	 * ��ҳ��ȡ����
	 *  pageNo:��ȡ�ڼ�ҳ                pageSize��ÿҳ�м�������
	 * */
	
	public PageFind<Product> findProductPage(int pageNo, int pageSize);
	
	/**
	 * ��ҳ�ڶ���
	 * */
	
	
}
