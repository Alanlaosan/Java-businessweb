package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class NyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory=null;
    //��̬�����
    static {
        //1��ȡ�����ļ�
        String resource = "config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
            //2������SqlSessionFactory��ΪSqlSession�Ĺ��������ڽ��������ݿ�ĻỰ
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡSqlSessionFactory
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
