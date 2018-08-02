package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class NyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory=null;
    //静态代码块
    static {
        //1读取配置文件
        String resource = "config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
            //2，生成SqlSessionFactory，为SqlSession的工厂，用于建立与数据库的会话
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取SqlSessionFactory
     * */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    /**
     * sqlSession
     * */
    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }
}
