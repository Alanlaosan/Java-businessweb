package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//ǿ������ת��
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		String username = null;
		String password = null;
		Cookie[] cookis=_request.getCookies();
		if(cookis!=null) {
			//��ǿ��forѭ��
			for(Cookie c:cookis) {
				if(c.getName().equals("username")) {
					//�û���
					username = c.getValue();
					//���������Ҫ��
					System.out.println("===Cookieusername======"+username+c.getMaxAge());
				}
				if(c.getName().equals("password")) {
					//����
					password = c.getValue();
					
					System.out.println("===Cookiepassword======"+password);
				}
			}
		}
		
		
		if(username!=null&&password!=null&&!username.equals("")&&!password.equals("")) {
			ILoginService loginService=new LoginServiceImpl();
			
			Account acc= loginService.doLogin(username, password);
			if(acc!=null) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
				//return;
			}else {
				System.out.println("������仰ִ���ˣ��������ͨ��������");
				chain.doFilter(request, response);
			}
			
		}else{
		chain.doFilter(request, response);
		}
		
		
		//chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
