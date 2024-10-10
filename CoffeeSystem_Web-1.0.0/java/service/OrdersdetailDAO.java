package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.OrderDetail;

public class OrdersdetailDAO {

	private ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
	private static final String SQL_SELECT_BY_ID_ORDERSDETAIL = "select * from Ordersdetail where id = ?";
	private static final String SQL_INSERT_INTO_ORDERSDETAIL = "insert into Ordersdetail(detailid,productid,ordersid,quentity,note) values (?,?,?,?,?)";
	private static final String SQL_SELECT_BY_ID_ORDERSDETAIL_QUENTITY = "select quentity from Ordersdetail where productid = ?";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/harumicoffeedb",
				"root", "mysql");

		return conn;
	}

	public OrderDetail selectID(String id) {
		OrderDetail orderDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID_ORDERSDETAIL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			readResultSet(rs);
			if (list.size() > 0) {
				orderDetail = list.get(0);
			}
			return orderDetail;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	public int insertOrderDetail(int detailid, String productid, int ordersid, int cnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT_INTO_ORDERSDETAIL);
			pstmt.setInt(1, detailid);
			pstmt.setString(2, productid);
			pstmt.setInt(3, ordersid);
			pstmt.setInt(4, cnt);
			pstmt.setString(5, "備考");
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
			OrderDetail ordersdetail = new OrderDetail();
			ordersdetail.setDetailId(rs.getInt("detailid"));
			ordersdetail.setProductid(rs.getString("productid"));
			ordersdetail.setOrdersid(rs.getInt("ordersid"));
			ordersdetail.setNote(rs.getString("note"));
			ordersdetail.setQuentity(rs.getInt("quentity"));
			list.add(ordersdetail);
		}
	}

	//商品IDごとに合計個数を求めて返す
	public int selectProductID(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID_ORDERSDETAIL_QUENTITY);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count += rs.getInt("quentity");
			}
			return count;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}

	}

}