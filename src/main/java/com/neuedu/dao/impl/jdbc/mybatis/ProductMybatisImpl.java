package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductMybatisImpl implements ProductDao{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public boolean addProduct(Product product) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int result=sqlSession.insert("com.neuedu.entity.Product.addProduct",product);
        /*sqlSession.commit();*/
        System.out.println(result);
        return true;

    }

    @Override
    public List<Product> findAll() {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        List<Product> list= sqlSession.selectList("com.neuedu.entity.Product.findAll");
        return list;
    }

    @Override
    public String findAllByJson() {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int result = sqlSession.update("com.neuedu.entity.Product.updateProduct",product);
        System.out.println(result);
        /*sqlSession.commit();
        sqlSession.close();*/
        return true;

    }

    @Override
    public boolean deleteProduct(int id) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int a= sqlSession.delete("com.neuedu.entity.Product.deleteProduct",id);
        System.out.println(a);
        /*sqlSession.commit();
        sqlSession.close();*/
        return true;
    }

    @Override
    public Product findById(int id) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        Product product= sqlSession.selectOne("com.neuedu.entity.Product.findById",id);
        /*sqlSession.close();*/
        return product;
    }

    @Override
    public PageFind<Product> findProductPage(int pageNo, int pageSize) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        //查询总页数
        int totalcount=sqlSession.selectOne("com.neuedu.entity.Product.findTotalpage");
        //查询某页的数据
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> list= sqlSession.selectList("com.neuedu.entity.Product.findProductPage",map);
        PageFind<Product> pageFind = new PageFind<Product>();
        pageFind.setTotalpage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1);
        pageFind.setData(list);
        return pageFind;
    }
}
