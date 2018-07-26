package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DBUtils;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public boolean addOrderItems(List<UserOrderItem> orederItems) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			
			st=conn.createStatement();
		
		
			String sql="insert into userorderitem(order_no,user_id,productid,product_name,product_image,current_unit_price,quantity,total_price,create_time) values";
			 StringBuffer sbuffer=new StringBuffer(sql);
			 
			 for(int i=0;i<orederItems.size();i++) {
				
				 UserOrderItem userOrderItem=orederItems.get(i);
				 sbuffer.append("(");
				 
				 sbuffer.append(userOrderItem.getOrder_no()+",");
				 sbuffer.append(userOrderItem.getUser_id()+",");
				 sbuffer.append(userOrderItem.getProduct_id()+",");
				 sbuffer.append("'"+userOrderItem.getProduct_name()+"',");
				 sbuffer.append("'"+userOrderItem.getProduct_image()+"',");
				 sbuffer.append(userOrderItem.getCurrent_unit_price()+",");
				 sbuffer.append(userOrderItem.getQuantity()+",");
				 sbuffer.append(userOrderItem.getTotal_price()+",");
				 sbuffer.append("now()");
				 sbuffer.append(")");
				 
				 if(i!=orederItems.size()-1) {
					 sbuffer.append(",");
				 }
				
				 
			 }
			 
			
			
			
			System.out.println(sbuffer);
			st.execute(sbuffer.toString());
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
