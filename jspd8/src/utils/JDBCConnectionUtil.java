package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/tintuc?useUnicode=true&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String password = "";

	private static Connection con = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to database");
		} catch (ClassNotFoundException e) {
			System.err.println("Couldn't load driver");
		} catch (SQLException e) {
			System.err.println("Couldn't connect to database");
		}
		return con;
	}
	
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				System.out.println("Resultset closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(Statement st) {
		if (st != null) {
			try {
				st.close();
				System.out.println("Statement closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(PreparedStatement pstate) {
		if (pstate != null) {
			try {
				pstate.close();
				System.out.println("PreparedStatement closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
