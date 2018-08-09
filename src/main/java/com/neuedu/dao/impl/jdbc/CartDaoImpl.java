package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CartDaoImpl implements CartDao {

	ProductDao productDao = new ProductDaoImpl();

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into cart(productid,productnum) values (" + cart.getProduct().getId() + ","
					+ cart.getProductNum() + ")";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from cart where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
		
			String sql = "update cart set productnum=? where productid=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, cart.getProductNum());
			st.setInt(2, cart.getProductid());
			System.out.println(sql);
			st.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub

		List<Cart> carts = new ArrayList<Cart>();

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int productid = rs.getInt("productid");
				int num = rs.getInt("productnum");

				Cart cart = new Cart();
				cart.setId(id);
				cart.setProductNum(num);

				cart.setProduct(productDao.findById(productid));

				carts.add(cart);

			}

			return carts;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productnum=" + num + " where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public PageFind<Cart> findCartPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageFind<Cart> pagefind = new PageFind<Cart>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();

			// String sql="select id,name,pdesc,price,rule ,image,stock from product";
			String sqlcount = "select count(id) from  cart ";
			pst = conn.prepareStatement(sqlcount);
			rs = pst.executeQuery();
			if (rs.next()) {
				int totalcount = rs.getInt(1);
				int totalpage = (totalcount % pageSize) == 0 ? totalcount / pageSize : (totalcount / pageSize + 1);
				pagefind.setTotalpage(totalpage);

			}
			String sql = "select id,productid,productnum from  cart limit ?,?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (pageNo - 1) * pageSize);
			pst.setInt(2, pageSize);
			System.out.println(sql);
			rs = pst.executeQuery();
			List<Cart> list = new ArrayList<Cart>();// 循环要保证吧商品放在同一个集合里，不能放在while循环里
			while (rs.next()) {
				int id = rs.getInt("id");
				int productid = rs.getInt("productid");
				System.out.println(productid);
				int productnum = rs.getInt("productnum");

				Cart cart = new Cart(id, productid, productnum);

				list.add(cart);
			}

			// 设置当前页面
			pagefind.setCurrentpage(pageNo);
			pagefind.setData(list);
			return pagefind;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		Cart cart = null;

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,productid,productnum from cart where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				cart = new Cart();
				int _id = rs.getInt("id");
				int productid = rs.getInt("productid");
				int productnum = rs.getInt("productnum");

				cart.setId(_id);
				cart.setProductid(productid);
				cart.setProductNum(productnum);
			}

			return cart;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cart;

	}

}
