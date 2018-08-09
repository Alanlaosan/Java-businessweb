package com.neuedu.controller;
//                                                     开始显示的页面
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.service.CategoryService;
import com.neuedu.service.impl.CategoryServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/categorybypage.do")
public class categorypage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService categoryService /*= new CategoryServiceImpl()*/;

	@Override
	public void init() throws ServletException {
		//获取ioc容器
		WebApplicationContext mWebApplicationContext
				= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//直接从容器中获取，就不用注入了
		categoryService =(CategoryService) mWebApplicationContext.getBean("categoryService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//分页模型
		String pageNo = request.getParameter("pageNo");
		PageFind<Category> pagefind = categoryService.findCagByPage(Integer.parseInt(pageNo), 4);
		request.setAttribute("pageFind", pagefind);
		request.getRequestDispatcher("View/showcategorybypage.jsp").forward(request, response);
		//super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
