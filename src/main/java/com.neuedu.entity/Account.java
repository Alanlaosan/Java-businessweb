package com.neuedu.entity;

/**账号*/
public class  Account{
	
	public  int  accountId;
	public  String  username;
	public  String  password;
	public  String  ip;
	public  String  sex;
	
	
	
    public Account(int accountId, String username, String password, String ip, String sex) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.sex = sex;
	}
	/**生成特定的账号对象*/
	public  Account(){}
	public  Account(int  accountId,String username,String password){
		this.accountId=accountId;
		this.username=username;
		this.password=password;
	}
	
	public  int  getAccountId(){
		return  accountId;
	}
	public  void  setAccountId(int accountId){
		this.accountId=accountId;
	}
	
	
	public  String  getUsername(){
		return username;
	}
	public  void  setUsername(String username){
		this.username=username;
	}
	
	public  String  getPassword(){
		return password;
	}
	public  void  setPassword(String password){
		this.password=password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
