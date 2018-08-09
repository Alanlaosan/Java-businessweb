package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageFind;
import com.neuedu.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao {

	
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "insert into category (name,cdesc,stock) values (?,?,?)";
			st = conn.prepareStatement(sql);               //预编译了sql语句
			// 占位符赋值
			st.setString(1, category.getName());
			st.setString(2, category.getDesc());
			st.setInt(3, category.getStock());
			System.out.println(sql);
			st.execute();                                  //这里直接调用sql语句了，括号里不要东西，因为不用调用sql语句了
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
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> categorys = new ArrayList<Category>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,cdesc,stock from  category";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String cdesc = rs.getString("cdesc");
				int stock = rs.getInt("stock");

				Category category = new Category(id, name, cdesc,stock);
				category.setStock(stock);
				categorys.add(category);

			}

			return categorys;

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
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "update category set name=?,cdesc=?,stock=? where id=?";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setString(1, category.getName());
			st.setString(2, category.getDesc());
			st.setInt(3, category.getStock());
			st.setInt(4, category.getId());
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
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from category where id=?";
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
	public Category findById(int id) {

		// TODO Auto-generated method stub
		Category category = null;

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,cdesc,stock from  category where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				category = new Category();
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String cdesc = rs.getString("cdesc");
				int stock = rs.getInt("stock");

				category.setId(_id);
				category.setName(name);
				category.setDesc(cdesc);
				category.setStock(stock);
			}

			return category;

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

		return category;
	}

	@Override
	
	public PageFind<Category> findCategoryPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageFind<Category> pagefind=new PageFind<Category>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String  sqlcount="select count(id) from  category ";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
			int totalcount=rs.getInt(1);
			int totalpage=(totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1);
			pagefind.setTotalpage(totalpage);
			
			}
			String  sql="select id,name,cdesc,stock from  category limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2,pageSize);
			System.out.println(sql);
			rs=pst.executeQuery();
			List<Category> list=new ArrayList<Category>();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String cdesc=rs.getString("cdesc");
			 int  stock= rs.getInt("stock");	
			 
			 Category category=new Category(id,name,cdesc,stock);
			 
			 list.add(category);
			}
			//当前页面
			pagefind.setCurrentpage(pageNo);
			pagefind.setData(list);
			return pagefind;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
}

	
