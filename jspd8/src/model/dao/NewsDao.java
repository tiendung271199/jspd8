package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.News;
import utils.JDBCConnectionUtil;

public class NewsDao {
	private JDBCConnectionUtil connectDB;
	private Connection conn;
	private ResultSet result;
	private PreparedStatement pstate;
	
	public NewsDao() {
		connectDB = new JDBCConnectionUtil();
	}
	
	public ArrayList<News> getItems(int idCat) {
		ArrayList<News> listNews = new ArrayList<News>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM tintuc WHERE ID_DanhMucTin=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, idCat);
			result = pstate.executeQuery();
			while (result.next()) {
				News objNews = new News(result.getInt("ID_TinTuc"), result.getString("TenTinTuc"), result.getString("MoTa"), result.getString("ChiTiet"));
				listNews.add(objNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result);
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return listNews;
	}

	public int addNews(News objNews) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "INSERT INTO tintuc(TenTinTuc,MoTa,ChiTiet,HinhAnh,ID_DanhMucTin) VALUES (?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, objNews.getName());
			pstate.setString(2, objNews.getPreview());
			pstate.setString(3, objNews.getDetail());
			pstate.setString(4, objNews.getPicture());
			pstate.setInt(5, objNews.getIdDanhMuc());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return rs;
	}

	public int editNews(News objNews) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "UPDATE tintuc SET TenTinTuc = ?, MoTa = ? WHERE ID_TinTuc = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, objNews.getName());
			pstate.setString(2, objNews.getPreview());
			pstate.setInt(3, objNews.getId());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate);
			connectDB.close(conn);
		}
		return rs;
	}

	public int deleteNews(int idNews) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "DELETE FROM tintuc WHERE ID_TinTuc = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, idNews);
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
