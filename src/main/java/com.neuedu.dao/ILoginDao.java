package com.neuedu.dao;

import com.neuedu.entity.Account;

//接口隔离原则
public interface ILoginDao {

	public  Account   doLogin(String _username, String _password);
		
	public void addToken(String token, Account acc);
	
	public String findTokenByAccountid(int accountid);

	
}
