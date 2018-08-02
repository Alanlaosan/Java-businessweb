package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.Account;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoMybatisImpl implements OrderDao{
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();

        OrderDao orderDao =  sqlSession.getMapper(OrderDao.class);
        orderDao.createOrder(userOrder);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public int generateOrderId() {

        return 0;
    }

    @Override
    public UserOrder findOrderByOrderno(long orderno) {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();

        OrderDao orderDao =  sqlSession.getMapper(OrderDao.class);
        UserOrder userOrder= orderDao.findOrderByOrderno(orderno);
        sqlSession.close();
        return userOrder;
    }
}
