package com.neuedu.test;

import com.neuedu.dao.OrderDao;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.dao.impl.jdbc.mybatis.OrderDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    OrderService orderService=null;
    OrderDao orderDao=null;
    @Before
    public void before(){
        orderService=new OrderServiceImpl();
        orderDao=new OrderDaoMybatisImpl();
    }
    @Test
    public void testCreateOrder(){
        orderService.createOrder();
    }
    @Test
    public void testFindOrderByorderno(){

        System.out.println(orderDao.findOrderByOrderno(1533032140448L));
    }

    @After
    public void destory(){

        orderService=null;
        orderDao=null;
    }

}
