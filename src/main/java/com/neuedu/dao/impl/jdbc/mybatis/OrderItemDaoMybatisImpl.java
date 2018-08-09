package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderItemDaoMybatisImpl implements OrderItemDao{
    @Override
    public boolean addOrderItems(List<UserOrderItem> orederItems) {

        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();

        OrderItemDao orderItemDao =  sqlSession.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItems(orederItems);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public int generateOrderItemId() {

        return 0;
    }
}
