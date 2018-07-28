package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatisImpl implements ILoginDao{

    @Override
    public Account doLogin(String _username, String _password) {

        //1，读取配置文件 ，读取配置文件
        //2，生成 ，生成SqlSessionFactory 为SqlSession的工厂，用于建立与数据库的会话。
        //3，建立 ，建立SqlSession 用于执行sql语句
        //4，调用 ，调用MyBatis提供的api
        //5，查询 ，查询Map配置
        //6，返回结果 ，返回结果
        //7，关闭 ，关闭SqlSession

        String resource = "config.xml";
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
        return account;
    }

    @Override
    public void addToken(String token, Account acc) {

    }

    @Override
    public String findTokenByAccountid(int accountid) {
        return null;
    }
}
