package com.neuedu.service.impl;

import javax.servlet.http.HttpSession;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.dao.impl.jdbc.mybatis.LoginMybatisImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.utils.MD5Utils;

public class LoginServiceImpl implements ILoginService{

	
	//ILoginDao loginDao=new LoginMybatisImpl();
	ILoginDao loginDao=new LoginDaoImpl();
	public Account  doLogin(String  username,String password) {
		//进行登录的业务逻辑处理
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
		
		return loginDao.doLogin(username,password);
		
		
	}

	@Override
	public void addToken(String token,Account acc) {
		// TODO Auto-generated method stub
		
		loginDao.addToken(token, acc);
		
		
		
	}

	@Override
	public String findTokenByAccoutid(int accountid) {
		// TODO Auto-generated method stub
		return loginDao.findTokenByAccountid(accountid);
	}
	
}
