package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDao;

public class EditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		News objNews = new News(15, "Trung tâm đào tạo lập trình viên VINAENTER", "Đào tạo các khoá học lập trình JAVA/ANDROID/PHP từ A-Z");
		NewsDao newsDao = new NewsDao();
		if (newsDao.editNews(objNews) > 0) {
			// sửa thành công
			System.out.println("Sửa tin thành công!");
		} else {
			// sửa thất bại
			System.out.println("Sửa tin thất bại!");
		}
	}

}
