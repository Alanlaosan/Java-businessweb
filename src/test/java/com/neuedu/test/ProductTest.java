package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisDao;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisImpl;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class ProductTest {


    ProductDao productDao;

    public void TestProduct(){
        ProductDao productDao=new ProductMybatisImpl();
        Product product=productDao.findById(42);
        System.out.println(product);
    }

    @Test
    public void TestfindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        productDao = applicationContext.getBean(ProductDao.class);
        /*ProductDao productDao=new ProductMybatisImpl();*/
        List<Product> list=productDao.findAll();
        System.out.println(list);

    }


    public void TestfindProductPage(){
        ProductDao productDao=new ProductMybatisImpl();
        PageFind<Product> pageFind=productDao.findProductPage(1,2);
        System.out.println(pageFind);
        //pagefind里面需要tostring
    }



    //name,pdesc,price,rule,image,stock
    public void TestAddProduct(){
        /*ProductDao productDao=new ProductMybatisImpl();*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        productDao = applicationContext.getBean(ProductDao.class);
        Product product=new Product();

        product.setId(43);
        product.setName("姚明");
        product.setDesc("减肥");
        product.setPrice(100000.0);
        product.setRule("130");
        product.setImage("http:sf");
        product.setStock(1);
        //程序从上到下执行到这里，添加到数据库
        //productDao.addProduct(product);
        //productDao.updateProduct(product);//根据id查询所以id要和数据库一致
        productDao.deleteProduct(43);
    }


}