package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Name;
import java.util.List;

public class CartDaoTest {

    CartDao cartDao=null;
    @Before
    public void before(){
        cartDao = new CartDaoMybatisImpl();
    }
    @Test
    public void testAddCart(){
//        Cart cart = new Cart();
//        Product product = new Product(40,"米","手机",7000,"1.0");
//        cart.setProduct(product);
//        cart.setProductNum(10);
//        cartDao.addCart(cart);
          List<Cart> list= cartDao.findAllCart();
        for (Cart  s:list
             ) {System.out.println(s);

        }

    }
    @After
    public void destory(){
        cartDao=null;
    }
}
