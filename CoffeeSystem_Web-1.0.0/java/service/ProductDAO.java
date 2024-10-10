package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Product;

public class ProductDAO {

	private ArrayList<Product> list = new ArrayList<Product>();
	private static final String SQL_SELECT_BY_ID_PRODUCT = "select * from product where id = ?";
	private static final String SQL_SELECT_PRODUCT = "select * from product";
	//おまじない

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/harumicoffeedb",
				"root", "mysql");

		return conn;
	}

	public Product selectID(String id) {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID_PRODUCT);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			readResultSet(rs);
			if (list.size() > 0) {
				product = list.get(0);
			}
			return product;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	//全抽出
	public ArrayList<Product> selectAll() {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_PRODUCT);
			rs = pstmt.executeQuery();
			readResultSet(rs);
			if (list.size() > 0) {
				product = list.get(0);
			}
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	private void readResultSet(ResultSet rs) throws SQLException {
		list.clear();
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getString("id"));
			product.setName(rs.getString("name"));
			product.setUnitPrice(rs.getInt("unitPrice"));
			product.setUnitAmount(rs.getInt("unitAmount"));
			product.setNote(rs.getString("note"));
			list.add(product);
		}
	}
}