<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Page - JAVA38</title>
</head>
<body>
	<h1>Danh sách các phần JAVA cần học</h1>
	<%!public static final int a = 10;

	public int random() {
		Random rd = new Random();
		int n = rd.nextInt(11);
		return n;
	}%>
	<%
		//scriplet
	int n = random();
	//out.print("Number: " + n);
	if (n % 2 == 0) {
	%>
	<%="Number: " + n%>
	<ul>
		<li>JAVA Core</li>
		<li>HTML/CSS/JS</li>
		<li>MySQL</li>
		<li>JSP/SERVLET</li>
	</ul>
	<%
		}
	%>

</body>
</html>