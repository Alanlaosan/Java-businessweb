package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.impl.jdbc.CategoryDaoImpl;
import com.neuedu.dao.impl.jdbc.mybatis.CategoryMybatisImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	//CategoryDao categoryDao=new CategoryDaoImpl();
	CategoryDao categoryDao/*=new CategoryMybatisImpl()*/;
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		
		return categoryDao.addCategory(category);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}

	@Override
	public PageFind<Category> findCagByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return categoryDao.findCategoryPage(pageNo, pageSize);
	}

	
}
