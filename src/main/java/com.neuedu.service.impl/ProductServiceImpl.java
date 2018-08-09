package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisImpl;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pService")
public class ProductServiceImpl implements ProductService {


	@Autowired
	//ProductDao productDao=new ProductDaoImpl();
	ProductDao productDao/*=new ProductMybatisImpl()*/;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public PageFind<Product> findProByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return productDao.findProductPage(pageNo, pageSize);
	}

	
}
