package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * 负责接收用户用户名、密码
 * 注解
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2127867611341493332L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ILoginService  loginService=new LoginServiceImpl();
		
		/*String username = null;
		String password = null;
		Cookie[] cookis=request.getCookies();
		if(cookis!=null) {
		//加强的for循环
			for(Cookie c:cookis) {
				if(c.getName().equals("username")) {
					//用户名
					username = c.getValue();
					c.setMaxAge(0);
					response.addCookie(c);
					System.out.println("===username======"+username+c.getMaxAge());
				}
				if(c.getName().equals("password")) {
					//密码
					password = c.getValue();
					c.setMaxAge(0);
					response.addCookie(c);
					System.out.println("===password======"+password);
				}
			}
		}
		
		
		if(username!=null&&password!=null&&!username.equals("")&&!password.equals("")) {
			Account acc= loginService.doLogin(username, password);
			if(acc!=null) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
				return;
			}else {
				//登陆失败
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
			
		}*/
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//用MD5加密password
		Account acc= loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		if(acc!=null) {
			//登陆成功
			
			Cookie cookie = new Cookie("username",username);
			cookie.setMaxAge(7*24*3600);
			response.addCookie(cookie);
			Cookie pwd_cookie = new Cookie("password",MD5Utils.GetMD5Code(password));
			pwd_cookie.setMaxAge(7*24*3600);
			response.addCookie(pwd_cookie);
			
			//生成token，存放在数据库当中
			
			long time=System.currentTimeMillis();
			String token=MD5Utils.GetMD5Code(username+password+time);
			loginService.addToken(token,acc);

			//token放到会话域中
			HttpSession session=request.getSession();
			session.setAttribute("token", token);
			session.setAttribute("acc", acc);
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			//登陆失败
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
