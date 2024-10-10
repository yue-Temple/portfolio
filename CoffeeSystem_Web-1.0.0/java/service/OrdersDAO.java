package service;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.Order;
 
public class OrdersDAO {
	
	
	private ArrayList<Order> list = new ArrayList<Order>();
	private static final String SQL_SELECT_BY_ID_ORDERS = "select * from orders where id = ?";
	private static final String SQL_INSERT_INTO_ORDER = "insert into orders(id,staffid,orderTime,note) value (?,?,?,?)";
 
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
 
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/harumicoffeedb",
				"root", "mysql");
 
		return conn;
	}
 
	public Order selectID(String id) {
		Order  order = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID_ORDERS);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			readResultSet(rs);
			if (list.size() > 0) {
				order = list.get(0);
			}
			return order;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
 
	}
	private int insertOrder(int id,String staffid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT_INTO_ORDER);
			pstmt.setInt(1, id);
			pstmt.setString(2, staffid);
			pstmt.setTimestamp(3, timestamp);
			pstmt.setString(4, "備考");
			count = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
		return count;
	}
 
	private void readResultSet(ResultSet rs) throws SQLException {
		list.clear();
		while (rs.next()) {
			Order  orders = new Order();
			orders.setId(rs.getInt("id"));
			orders.getStaff().setId(rs.getString("staffid"));
			orders.setOrderTime(rs.getTimestamp("orderTime"));
			orders.setNote(rs.getString("note"));
			list.add(orders);
		}
	}
	
}