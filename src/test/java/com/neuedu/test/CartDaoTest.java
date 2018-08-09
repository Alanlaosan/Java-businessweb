package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Name;
import java.util.List;

public class CartDaoTest {

    CartDao cartDao/*=null*/;

    @Before
    public void before() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        cartDao = applicationContext.getBean(CartDao.class);
    }


    public void testAddCart() {


        Cart cart = new Cart();
        Product product = new Product(100, "米", "手机", 7000, "1.0");
        cart.setProduct(product);
        cart.setProductNum(10);
        cartDao.addCart(cart);
        /*List<Cart> list= cartDao.findAllCart();
        for (Cart  s:list
             ) {System.out.println(s);
        }*/
    }
    @Test
    public void testDelectCart(){
        cartDao.deleteCart(16);
    }


    @After
    public void destory() {
        cartDao = null;
    }
}
