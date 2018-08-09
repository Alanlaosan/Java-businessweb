package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryMybatisImpl implements CategoryDao{


    @Autowired
    private SqlSession sqlSession;

    @Override
    public boolean addCategory(Category category) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int a= sqlSession.insert("com.neuedu.entity.Category.addCategory",category);
        /*sqlSession.commit();*/
        System.out.println(a);
        return true;
    }

    @Override
    public List<Category> findAll() {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        List<Category> list = sqlSession.selectList("com.neuedu.entity.Category.findAll");
        return list;
    }

    @Override
    public boolean updateCategory(Category category) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int a = sqlSession.update("com.neuedu.entity.Category.updateCategory",category);
        /*sqlSession.commit();
        sqlSession.close();*/
        return true;
    }

    @Override
    public boolean deleteCategory(int id) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        int a = sqlSession.delete("com.neuedu.entity.Category.deleteCategory",id);
        /*sqlSession.commit();
        sqlSession.close();*/
        return true;
    }

    @Override
    public Category findById(int id) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        Category category = sqlSession.selectOne("com.neuedu.entity.Category.findById",id);
        /*sqlSession.close();*/
        return category;
    }

    @Override
    public PageFind<Category> findCategoryPage(int pageNo, int pageSize) {
        /*SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        //查询总页数
        int totalcount = sqlSession.selectOne("com.neuedu.entity.Category.findTotalPage");
        //查询某页数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Category> list = sqlSession.selectList("com.neuedu.entity.Category.findCategoryPage",map);
        PageFind<Category> pageFind = new PageFind<Category>();
        pageFind.setTotalpage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1);
        pageFind.setData(list);
        return pageFind;

    }
}
