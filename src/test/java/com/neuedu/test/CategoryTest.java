package com.neuedu.test;

import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.mybatis.CategoryMybatisImpl;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import org.junit.Test;

import java.util.List;


public class CategoryTest {


    public void TestfindById(){
        CategoryDao categoryDao=new CategoryMybatisImpl();
        Category category=categoryDao.findById(30);
        System.out.println(category);
    }

    public void TestfindAll(){
        CategoryDao categoryDao=new CategoryMybatisImpl();
        List<Category> list=categoryDao.findAll();
        System.out.println(list);
    }

    @Test
    public void TestfindCategoryPage(){
        CategoryDao categoryDao=new CategoryMybatisImpl();
        PageFind<Category> pageFind=categoryDao.findCategoryPage(1,4);
        System.out.println(pageFind);
        //pagefind里面需要tostring
    }



    //name,cdesc,stock
    public void TestAddCategory(){
        CategoryDao categoryDao=new CategoryMybatisImpl();
        Category category = new Category();

        category.setId(31);
        category.setName("日用");
        category.setDesc("毛巾");
        category.setStock(100);
        //程序从上到下执行到这里，添加到数据库
        //categoryDao.addCategory(category);
        //categoryDao.updateCategory(category);//根据id查询所以id要和数据库一致
        //categoryDao.deleteCategory(32);
    }


}