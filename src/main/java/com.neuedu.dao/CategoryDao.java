package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;

public interface CategoryDao {

	 /**
	  * 添加商品
	  * */
	boolean  addCategory(Category category);
	/**
	 * 查看商品
	 * */
	List<Category> findAll();
	/**
	 * 修改商品
	 * */
	boolean  updateCategory(Category category);
	/**
	 * 删除商品
	 * */
	boolean  deleteCategory(int id);
	
	/**根据id查询商品*/
	Category  findById(int id);
	
	/**
	 * 分页获取参数
	 *  pageNo:获取第几页                pageSize：每页有几条数据
	 * */
	
	public PageFind<Category> findCategoryPage(int pageNo, int pageSize);
	
}
