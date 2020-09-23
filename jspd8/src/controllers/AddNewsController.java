package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDao;

public class AddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thêm tin vào table tintuc
		News objNews = new News(0, "Trung tâm đào tạo lâp trình VinaEnter", "Đào tạo lập trình PHP-JAVA-ANDROID",
				"Đào tạo lập trình PHP-JAVA-ANDROID", "vinaenter.png", 6);
		NewsDao newsDao = new NewsDao();
		if (newsDao.addNews(objNews) > 0) {
			// Thêm thành công
			System.out.println("Thêm tin thành công!");
		} else {
			// Thêm thất bại
			System.out.println("Thêm tin thất bại!");
		}
	}

}
