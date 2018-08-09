package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.service.CategoryService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CategoryServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/View/category")
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8139639075549663507L;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String operation = request.getParameter("operation");

		if (operation != null && !operation.equals("")) {
			if (operation.equals("1")) {
				addCategory(request, response);
			} else if (operation.equals("2")) {
				findAll(request, response);
			} else if (operation.equals("3")) {
				updateCategory(request, response);
			} else if (operation.equals("4")) {
				deleteCategory(request, response);
			} else if (operation.equals("5")) {
				findCategoryById(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}


	public void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		String name = request.getParameter("cname");
		String desc = request.getParameter("cdesc");
		int stock = 0;
		boolean result = false;
		try {
			stock = Integer.parseInt(request.getParameter("stock"));
			category.setName(name);
			category.setDesc(desc);
			category.setStock(stock);
			result = addCategory(category);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("类别添加成功");
			findAll(request, response);
		} else {
			System.out.println("类别添加失败");
		}
	}

	/** 添加商品 */
	public boolean addCategory(Category category) {
		return categoryService.addCategory(category);
	}

	/**
	 * 查询商品
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Category> category = pService.findAll();
//
//		request.setAttribute("category", category);
//		request.getRequestDispatcher("showcategorybypage.jsp").forward(request, response);
		
		String pageNo=request.getParameter("pageNo");
    	String pageSize=request.getParameter("pageSize");
    	int _pageNo=1;
    	int _pageSize=4;
    	try {
    		if(pageNo!=null&&pageSize!=null) {
    			_pageNo=Integer.parseInt(pageNo);
    			_pageSize=Integer.parseInt(pageSize);
    		}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	PageFind<Category> pagefind=categoryService.findCagByPage(_pageNo, _pageSize);
        
    	request.setAttribute("pageFind",pagefind);
    	request.getRequestDispatcher("showcategorybypage.jsp").forward(request, response);

	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Category category = new Category();
		String name = request.getParameter("cname");
		String desc = request.getParameter("cdesc");
		int stock = 0;
		int id=0;
		boolean result = false;
		try {
			System.out.println("stock="+request.getParameter("stock"));
			stock = Integer.parseInt(request.getParameter("stock"));
			id = Integer.parseInt(request.getParameter("id"));
			category.setId(id);
			category.setName(name);
			category.setDesc(desc);
			category.setStock(stock);
			result = updateCategory(category);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("类别修改成功");
			findAll(request, response);
		} else {
			System.out.println(result+"=====================");
			System.out.println("类别修改失败");
		}
	}

	/** 修改类别 */
	public boolean updateCategory(Category category) {
		// return pService.updateProduct(product);
	    return categoryService.updateCategory(category);
	}

	/**
	 * 删除商品
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(sid);
			boolean result = categoryService.deleteCategory(id);

			if (result) {
				findAll(request, response);
			} else {
				System.out.println("删除id=" + id + "的类别失败！！！");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private void findCategoryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Category category = categoryService.findCategoryById(id);
			if (category != null) {
				// 查询成功
				request.setAttribute("category", category);
				request.getRequestDispatcher("updatecategory.jsp").forward(request, response);
			} else {

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public Category findCategoryById(int id) {
		return categoryService.findCategoryById(id);
	}

}
