package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/View/product")
public class ProductController extends HttpServlet {

	ProductService pService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html;charset=UTF-8");
		String operation = request.getParameter("operation");

		if (operation != null && !operation.equals("")) {
			if (operation.equals("1")) {
				addProduct(request, response);
			} else if (operation.equals("2")) {
				findAll(request, response);
			} else if (operation.equals("3")) {
				updateProduct(request, response);
			} else if (operation.equals("4")) {
				deleteProduct(request, response);
			} else if (operation.equals("5")) {
				findProductById(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	// public void addProduct(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// Product product = new Product();
	//
	// String name = request.getParameter("pname");
	// String desc = request.getParameter("pdesc");
	// String image = request.getParameter("pimage");
	// String rule = request.getParameter("rule");
	// int stock = 0;
	// double price = 0.0;
	// boolean result = false;
	//
	// try {
	// price = Double.parseDouble(request.getParameter("price"));
	// stock = Integer.parseInt(request.getParameter("stock"));
	// product.setName(name);
	// product.setDesc(desc);
	// product.setPrice(price);
	// product.setImage(image);
	// product.setRule(rule);
	// product.setStock(stock);
	// result = addProduct(product);
	//
	// } catch (NumberFormatException e) {
	// e.printStackTrace();
	// }
	// if (result) {
	// System.out.println("商品添加成功");
	// findAll(request, response);
	// } else {
	// System.out.println("商品添加失败");
	// }
	//
	// }

	public void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		String name = request.getParameter("pname");
		String desc = request.getParameter("pdesc");
		String image = request.getParameter("pimage");
		String rule = request.getParameter("prule");
		int stock = 0;
		double price = 0.0;
		boolean result = false;
		try {
			price = Double.parseDouble(request.getParameter("price"));
			stock = Integer.parseInt(request.getParameter("stock"));
			product.setName(name);
			product.setDesc(desc);
			product.setPrice(price);
			product.setImage(image);
			product.setRule(rule);
			product.setStock(stock);
			result = addProduct(product);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("商品添加成功");
			findAll(request, response);
		} else {
			System.out.println("商品添加失败");
		}
	}

	/** 添加商品 */
	public boolean addProduct(Product product) {
		return pService.addProduct(product);
	}

	/**
	 * 查询商品
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		int _pageNo = 1;
		int _pageSize =4;
		try {
			_pageNo = Integer.parseInt(pageNo);
			_pageSize = Integer.parseInt(pageSize);
			
			

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("shicaile");
		PageFind<Product> pagefind = pService.findProByPage(_pageNo, _pageSize);

		request.setAttribute("pagefind", pagefind);
		request.getRequestDispatcher("findallbypage.jsp").forward(request, response);*/
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
    	PageFind<Product> pagefind=pService.findProByPage(_pageNo, _pageSize);
    	
    	request.setAttribute("PaGeFind",pagefind);
    	request.getRequestDispatcher("findallbypage.jsp").forward(request, response);
    	


	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Product product = new Product();
		String name = request.getParameter("pname");
		String desc = request.getParameter("pdesc");
		String image = request.getParameter("pimage");
		String rule = request.getParameter("prule");
		int stock = 0;
		int id=0;
		double price = 0.0;
		boolean result = false;
		try {
			price = Double.parseDouble(request.getParameter("price"));
			System.out.println("stock="+request.getParameter("stock"));
			stock = Integer.parseInt(request.getParameter("stock"));
			id = Integer.parseInt(request.getParameter("id"));
			product.setId(id);
			product.setName(name);
			product.setDesc(desc);
			product.setPrice(price);
			product.setImage(image);
			product.setRule(rule);
			product.setStock(stock);
			result = updateProduct(product);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("商品修改成功");
			findAll(request, response);
		} else {
			System.out.println("商品修改失败");
		}
	}

	/** 修改商品 */
	public boolean updateProduct(Product product) {
		// return pService.updateProduct(product);
	    return pService.updateProduct(product);
	}

	/**
	 * 删除商品
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(sid);
			boolean result = pService.deleteProduct(id);

			if (result) {
				findAll(request, response);
			} else {
				System.out.println("删除id=" + id + "的商品失败！！！");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	private void findProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Product product = pService.findProductById(id);
			if (product != null) {
				// 查询成功
				request.setAttribute("product", product);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} else {

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public Product findProductById(int id) {
		return pService.findProductById(id);
	}

}
