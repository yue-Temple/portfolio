package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Staff;


public class StaffDAO {


	private ArrayList<Staff> list = new ArrayList<Staff>();
	private static final String SQL_SELECT_BY_ID_STAFF = "select * from staff where id = ?";

	//db
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/harumicoffeedb",
				"root", "mysql");

		return conn;
	}
	
	public Staff selectID(String id) {
		Staff staff = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID_STAFF);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			readResultSet(rs);
			
			if (list.size() > 0) {
				staff = list.get(0);
			}
			
			return staff;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}
	private void readResultSet(ResultSet rs) throws SQLException {
		list.clear();
		while (rs.next()) {
			Staff staff = new Staff();
			staff.setId(rs.getString("id"));
			staff.setName(rs.getString("name"));
			staff.setDescription(rs.getString("description"));
			staff.setAuthorityLevel(rs.getInt("authorityLevel"));
			staff.setNote(rs.getString("note"));
			list.add(staff);
		}
	}
	
}