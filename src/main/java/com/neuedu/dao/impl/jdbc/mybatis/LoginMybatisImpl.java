package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.utils.DBUtils;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoginMybatisImpl implements ILoginDao{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Account doLogin(String _username, String _password) {

        //1，读取配置文件 ，读取配置文件
        //2，生成 ，生成SqlSessionFactory 为SqlSession的工厂，用于建立与数据库的会话。
        //3，建立 ，建立SqlSession 用于执行sql语句
        //4，调用 ，调用MyBatis提供的api
        //5，查询 ，查询Map配置
        //6，返回结果 ，返回结果
        //7，关闭 ，关闭SqlSession

        /*String resource = "config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();

        Map<String,String> map= new HashMap<String,String>();
        map.put("username",_username);
        map.put("password",_password);
        Account account = session.selectOne("com.neuedu.entity.Account.find",map);
        System.out.println(account);
        session.close();
        return account;*/
        /*交给ioc管理SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        //3，建立 ，建立SqlSession 用于执行sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",_username);
        map.put("password",_password);
        //4，调用 ，调用MyBatis提供的api    5，查询 ，查询Map配置
        Account account=sqlSession.selectOne("com.neuedu.entity.Account.find",map);
        //6，返回结果 ，返回结果
        System.out.println(account);
        //sqlSession.close();

       return account;

    }

    @Override
    public void addToken(String token, Account acc) {

        /*交给ioc管理SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();*/
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token",token);
        map.put("accountid",acc.accountId);
        sqlSession.update("com.neuedu.entity.Account.find",map);
        //sqlSession.commit();
        //MyBatisUtils.close(sqlSession);
        System.out.println("修改成功");
    }

    @Override
    public String findTokenByAccountid(int accountid) {
        /*交给ioc管理SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        String result=sqlSession.selectOne("com.neuedu.entity.Account.findTokenByAccountid",accountid);
        //sqlSession.close();
        System.out.println(result);
        return null;
    }

    @Override
    public List<Account> findAllUser() {

        /*交给ioc管理SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();*/
        List<Account> list= sqlSession.selectList("com.neuedu.entity.Account.findAllUser");
        return list;
    }

}

