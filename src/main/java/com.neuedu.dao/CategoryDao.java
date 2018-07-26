package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;

public interface CategoryDao {

	 /**
	  * �����Ʒ
	  * */
	boolean  addCategory(Category category);
	/**
	 * �鿴��Ʒ
	 * */
	List<Category> findAll();
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateCategory(Category category);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteCategory(int id);
	
	/**����id��ѯ��Ʒ*/
	Category  findById(int id);
	
	/**
	 * ��ҳ��ȡ����
	 *  pageNo:��ȡ�ڼ�ҳ                pageSize��ÿҳ�м�������
	 * */
	
	public PageFind<Category> findCategoryPage(int pageNo, int pageSize);
	
}
