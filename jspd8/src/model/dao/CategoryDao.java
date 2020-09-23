package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import utils.JDBCConnectionUtil;

public class CategoryDao {
	private JDBCConnectionUtil connectDB;
	private Connection conn;
	private Statement state;
	private ResultSet result;
	private PreparedStatement pstate;
	
	public CategoryDao() {
		connectDB = new JDBCConnectionUtil();
	}
	
	public ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<Category>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM danhmuctin";
		try {
			state = conn.createStatement();
			result = state.executeQuery(sql);
			while (result.next()) {
				Category obj = new Category(result.getInt("ID_DanhMucTin"), result.getString("TenDanhMucTin"));
				listItems.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result);
			connectDB.close(state);
			connectDB.close(conn);
		}
		return listItems;
	}

	public int addItem(Category objCat) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "INSERT INTO danhmuctin(TenDanhMucTin) VALUES (?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, objCat.getName());
			rs = pstate.executeUpdate(); // = 1
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return rs;
	}

	public int editItem(Category objCat) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "UPDATE danhmuctin SET TenDanhMucTin = ? WHERE ID_DanhMucTin = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, objCat.getName());
			pstate.setInt(2, objCat.getId());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return rs;
	}

	public int deleteCat(int idCat) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "DELETE FROM danhmuctin WHERE ID_DanhMucTin = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, idCat);
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return rs;
	}
	
	
}
