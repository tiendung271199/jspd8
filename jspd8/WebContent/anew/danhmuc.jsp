<%@page import="model.bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/anew/inc/header.jsp"%>
		
		<!-- end content -->
		<div id="content">
			<div class="content-left fl">
				<%@ include file="/anew/inc/sidebar.jsp"%>
			</div>
			<div class="content-right fr">
				<h3>Tin tức :: Thời sự</h3>
				<div class="main-content items-new">
					<ul>
						<%
							if (request.getAttribute("listNews") != null) {
								ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
								if (listNews.size() > 0) {
									for (News objNews : listNews) {
						%>
						<li>
							<h2>
								<a href="<%=request.getContextPath() %>/anew/chitiet.jsp" title=""><%=objNews.getName() %></a>
							</h2>
							<div class="item">
								<p><%=objNews.getPreview() %></p>
								<div class="clr"></div>
							</div>
						</li>
						<%
									}
								}
							}
						%>
					</ul>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end content -->
		
<%@ include file="/anew/inc/footer.jsp"%>
