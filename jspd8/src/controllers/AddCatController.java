package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDao;

public class AddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thêm danh mục tin vào table danhmuctin
		Category objCat = new Category(0, "Tin về lập trình");
		CategoryDao catDao = new CategoryDao();
		if (catDao.addItem(objCat) > 0) {
			// Thêm thành công
			System.out.println("Thêm danh mục thành công!");
		} else {
			// Thêm thất bại
			System.out.println("Thêm danh mục thất bại!");
		}
	}

}
