package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDao;

public class DelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCat = 5;
		CategoryDao catDao = new CategoryDao();
		if (catDao.deleteCat(idCat) > 0) {
			// xoá thành công
			System.out.println("Xoá thành công!");
		} else {
			// xoá thất bại
			System.out.println("Xoá thất bại!");
		}
	}

}
