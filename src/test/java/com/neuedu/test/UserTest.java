package com.neuedu.test;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.mybatis.LoginMybatisImpl;
import com.neuedu.entity.Account;
import org.junit.jupiter.api.Test;

import java.util.List;
//import com.neuedu.impl.jdbc.mybatis.LoginMybatisImpl;


public class UserTest {



    public  void testDoLogin(){

        ILoginDao loginDao=new LoginMybatisImpl();
        loginDao.doLogin("admin","21232f297a57a5a743894a0e4a801fc3");
    }

    @Test
    public  void testfindAllUser(){

        ILoginDao loginDao=new LoginMybatisImpl();
        List<Account> acc=loginDao.findAllUser();
        System.out.println(acc.size());
        System.out.println(acc);
    }

}
