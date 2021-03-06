package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * 商品分页是这里的
 * */
@WebServlet("/productbypage.do")
public class testpage extends HttpServlet{
	ProductService pService /*= new ProductServiceImpl()*/;

	@Override
	public void init() throws ServletException {
		//获取ioc容器
		WebApplicationContext mWebApplicationContext
				= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//直接从容器中获取，就不用注入了
		pService =(ProductService) mWebApplicationContext.getBean("pService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//分页模型
		String pageNo = request.getParameter("pageNo");
		PageFind<Product> pagefind = pService.findProByPage(Integer.parseInt(pageNo), 4);
		request.setAttribute("pageFind", pagefind);
		request.getRequestDispatcher("View/showproductbypage.jsp").forward(request, response);
		//super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
