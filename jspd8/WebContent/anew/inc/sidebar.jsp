<%@page import="model.dao.CategoryDao"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>Danh mục tin</h3>
<ul>
	<%
		ArrayList<Category> listCat = new CategoryDao().getItems();
		if (listCat.size() > 0) {
			for(Category objCat : listCat) {
	%>
	<li><a href="<%=request.getContextPath() %>/danh-muc?cid=<%=objCat.getId() %>"><%=objCat.getName() %></a></li>
	<%
			}
		}
	%>
</ul>