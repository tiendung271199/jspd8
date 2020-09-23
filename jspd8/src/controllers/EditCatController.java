package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDao;

public class EditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category objCat = new Category(6, "Tin về lập trình Java");
		CategoryDao catDao = new CategoryDao();
		if (catDao.editItem(objCat) > 0) {
			// Sửa thành công
			System.out.println("Sửa danh mục thành công!");
		} else {
			// Sửa thất bại
			System.out.println("Sửa danh mục thất bại!");
		}
	}

}
