package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Account;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoMybatisImpl implements CartDao{

    @Override
    public boolean addCart(Cart cart) {

        SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        CartDao cartDao= sqlSession.getMapper(CartDao.class);
        cartDao.addCart(cart);
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public boolean updataeCart(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> findAllCart() {
        SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        CartDao cartDao= sqlSession.getMapper(CartDao.class);
        List<Cart> list= cartDao.findAllCart();
        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public void clearCart() {
        SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        CartDao cartDao = sqlSession.getMapper(CartDao.class);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public PageFind<Cart> findCartPage(int pageNo, int pageSize) {
        return null;
    }
}
