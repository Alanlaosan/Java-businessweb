package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "insert into product(name,pdesc,price,rule,image,stock) values (?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,pdesc,price,rule ,image,stock from  product";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, name, pdesc, price, rule, image, stock);
				//product.setStock(stock);
				products.add(product);

			}

			return products;

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
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "update product set name=?,pdesc=?,price=?,rule=?,image=?,stock=? where id=?";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			st.setInt(7, product.getId());
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
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from product where id=?";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setInt(1, id);

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
	public Product findById(int id) {

		// TODO Auto-generated method stub
		Product product = null;

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,pdesc,price,rule ,image,stock from  product where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				product = new Product();
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				product.setId(_id);
				product.setName(name);
				product.setPrice(price);
				product.setDesc(pdesc);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
			}

			return product;

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

		return product;
	}

	@Override
	// public PageFind<Product> findProductPage(int pageNo, int pageSize) {
	// // TODO Auto-generated method stub
	//
	// PageFind<Product> pageFind = new PageFind<Product>();
	// Connection conn = null;
	// PreparedStatement pst = null;
	// ResultSet rs = null;
	// try {
	// conn = DBUtils.getConnection();
	// // 查询总的记录数
	// String sqlcount = "select count (id) from product";
	// pst = conn.prepareStatement(sqlcount);
	// rs = pst.executeQuery();
	// if(rs.next()){
	// int totalCount= rs.getInt(1);//总的记录
	// //计算总共多少页
	// int totalPage =
	// (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
	// pageFind.setTotalpage(totalPage);
	// }
	//
	// String sql = "select id,name,pdesc,price,rule ,image,stock from product limit
	// ?,?";
	// pst = conn.prepareStatement(sql);
	// pst.setInt(1, (pageNo-1) * pageSize);
	// pst.setInt(2, pageSize);
	// rs = pst.executeQuery();
	// List<Product> list = new ArrayList<Product>();
	// while (rs.next()) {
	// int id = rs.getInt("id");
	// String name = rs.getString("name");
	// String pdesc = rs.getString("pdesc");
	// double price = rs.getDouble("price");
	// String rule = rs.getString("rule");
	// String image = rs.getString("image");
	// int stock = rs.getInt("stock");
	//
	// Product product = new Product(id, name, pdesc, price, rule, image);
	// product.setStock(stock);
	// list.add(product);
	// System.out.println("成功吧");
	//
	// }
	// pageFind.setDate(list);
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// DBUtils.close(conn, pst);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return pageFind;
	// }

	// }

	public PageFind<Product> findProductPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageFind<Product> pagefind = new PageFind<Product>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();

			// String sql="select id,name,pdesc,price,rule ,image,stock from product";
			String sqlcount = "select count(id) from  product ";
			pst = conn.prepareStatement(sqlcount);
			rs = pst.executeQuery();
			if (rs.next()) {
				int totalcount = rs.getInt(1);
				int totalpage = (totalcount % pageSize) == 0 ? totalcount / pageSize : (totalcount / pageSize + 1);
				pagefind.setTotalpage(totalpage);

			}
			String sql = "select id,name,pdesc,price,rule ,image,stock from  product limit ?,?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (pageNo - 1) * pageSize);
			pst.setInt(2, pageSize);
			System.out.println(sql);
			rs = pst.executeQuery();
			List<Product> list = new ArrayList<Product>();// 循环要保证吧商品放在同一个集合里，不能放在while循环里
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, name, pdesc, price, rule, image, stock);

				list.add(product);
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
	public String findAllByJson() {
		
		return null;
	}
		

}
