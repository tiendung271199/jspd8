package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDao;

public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexCatPublicController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsDao objNewsDao = new NewsDao();
		int idCat = Integer.parseInt(request.getParameter("cid"));
		ArrayList<News> listNews = objNewsDao.getItems(idCat);
		request.setAttribute("listNews", listNews);
		RequestDispatcher rd = request.getRequestDispatcher("/anew/danhmuc.jsp");
		rd.forward(request, response);
	}

}
