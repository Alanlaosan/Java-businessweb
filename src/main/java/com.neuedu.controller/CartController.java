package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/View/cart")
public class CartController extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String operation = request.getParameter("operation");

		if (operation != null && !operation.equals("")) {
			if (operation.equals("1")) {
				addCart(request, response);
			} else if (operation.equals("2")) {
				findAllCart(request, response);
			} else if (operation.equals("3")) {
				updateCart(request, response);
			} else if (operation.equals("4")) {
				deleteCart(request, response);
			} else if (operation.equals("5")) {
				findCartById(request, response);
			} else if (operation.equals("6")) {
				findProductById(request, response);
			}
		}

		// super.doGet(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	CartService cartService = new CartServiceImpl();

	private void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		int productid = 0;
		int productnum = 0;
		boolean result = false;
		try {
			productid = Integer.parseInt(request.getParameter("id"));
			System.out.println(productid + "========");
			productnum = Integer.parseInt(request.getParameter("productnum"));
			ProductController pc = new ProductController();
			Product product = pc.findProductById(productid);
			if (product.getStock() >= productnum) {
				if (product != null) {
					cart.setProduct(product);
					cart.setProductid(product.getId());
					cart.setProductNum(productnum);
					result = addCart(cart);
					if (result) {
						System.out.println("��Ʒ��ӳɹ�");
						findAllCart(request, response);
					} else {
						System.out.println("��Ʒ���ʧ��");
					}
				} else {
					System.out.println("��Ʒ���ʧ��");
				}
			} else {
				request.getRequestDispatcher("addcartfail.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ӹ��ﳵ
	 **/
	public boolean addCart(Cart cart) {

		return cartService.addCart(cart);
	}

	private void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			boolean result = cartService.deleteCart(id);
			if (result) {
				System.out.println(id);

				if (cartService.deleteCart(id)) {
					System.out.println("��Ʒɾ���ɹ�");
					findAllCart(request, response);
				} else {
					System.out.println("��Ʒɾ��ʧ��");
				}
			} else {
				System.out.println(result + "==================" + id);
				System.out.println("��Ʒɾ��ʧ��");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ɾ��
	 */
	public boolean deleteCart(int id) {
		return cartService.deleteCart(id);
	}

	private void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		int id = 0;
		int productNum = 0;
		int productid = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			productNum = Integer.parseInt(request.getParameter("productNum"));
			productid = Integer.parseInt(request.getParameter("productid"));
			cart.setId(id);
			cart.setProductid(productid);
			cart.setProductNum(productNum);
			System.out.println(cart.getProductid());
			System.out.println(cart.getProductNum());
			result = updateCart(cart);
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("���ﳵ�޸ĳɹ�");
			findAllCart(request, response);
		} else {
			System.out.println("���ﳵ�޸�ʧ��");
		}

	}

	/**
	 * �޸Ĺ��ﳵ
	 */
	public boolean updateCart(Cart cart) {
		return cartService.updataeCart(cart);
		
	}

	private void findAllCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		int _pageNo = 1;
		int _pageSize = 4;
		try {
			if (pageNo != null && pageSize != null) {
				_pageNo = Integer.parseInt(pageNo);
				_pageSize = Integer.parseInt(pageSize);
			}
			PageFind<Cart> pagefind = cartService.findCartByPage(_pageNo, _pageSize);
			request.setAttribute("pagefind", pagefind);
			request.getRequestDispatcher("showcart.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * ��ѯ���ﳵ
	 */
	public List<Cart> findAllCart() {
		return cartService.findAllCart();
	}

	/**
	 * ��ȡ���ﳵ����Ʒ����
	 */
	public int getCartNum() {
		return cartService.getCartNum();
	};

	// /**
	// * �޸Ĺ��ﳵ��Ʒ����
	// *
	// * @param id
	// * Ҫ�޸ĵĹ��ﳵ��Id
	// * @param num
	// * �޸ĺ������
	// */
	// public boolean updateCart(int id, int num) {
	// return cartService.updateCart(id, num);
	// };

	/**
	 * ͨ��id��ȷ��ѯ
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */

	private void findCartById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = cartService.findCartById(id);
			request.setAttribute("cart", cart);
			if (cart!=null) {
				System.out.println("��ѯ�ɹ�");
				request.getRequestDispatcher("updatecart.jsp").forward(request, response);
				
			} else {
				System.out.println(cart+"========"+id);
				System.out.println("��ѯ���ɹ�");
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
			ProductService pService = new ProductServiceImpl();
			id = Integer.parseInt(request.getParameter("id"));
			Product product = pService.findProductById(id);
			request.setAttribute("product", product);
			System.out.println("======" + id + "+++++++++");
			if (product != null) {
				System.out.println("��ѯ�ɹ�");
				request.getRequestDispatcher("addcart.jsp").forward(request, response);
			} else {
				System.out.println("��ѯ���ɹ�");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

}
