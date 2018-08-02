package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductMybatisDao implements ProductDao{
    @Override
    public boolean addProduct(Product product) {

//        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        ProductDao productDao = sqlSession.getMapper(ProductDao.class);
//        productDao.addProduct(product);
//        sqlSession.commit();
//        sqlSession.close();
        return false;
    }

    @Override
    public List<Product> findAll() {

        return null;
    }

    @Override
    public String findAllByJson() {

        return null;
    }

    @Override
    public boolean updateProduct(Product product) {

        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ProductDao productDao = sqlSession.getMapper(ProductDao.class);
        productDao.updateProduct(product);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public PageFind<Product> findProductPage(int pageNo, int pageSize) {
        return null;
    }
}
