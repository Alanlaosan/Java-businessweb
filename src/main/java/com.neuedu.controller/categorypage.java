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
@WebServlet("/categorybypage.do")
public class categorypage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService pService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//分页模型
		String pageNo = request.getParameter("pageNo");
		PageFind<Category> pagefind = pService.findCagByPage(Integer.parseInt(pageNo), 4);
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
