package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			
			st=conn.createStatement();
		
			String  sql="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,create_time)"
					+ " values ("+userOrder.getOrder_no()+","+userOrder.getUser_id()+","+userOrder.getShipping_id()+","+userOrder.getPayment()+","+userOrder.getPayment_type()+","+userOrder.getPostage()+","+userOrder.getStatus()+",now())";
			System.out.println(sql);
			st.execute(sql);
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
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 在映射文件怎样获取参数
	 * 内置对象args0  args1……(orderno有多个)
	 * */
	@Override
	public UserOrder findOrderByOrderno(long orderno) {
		return null;
	}

}
