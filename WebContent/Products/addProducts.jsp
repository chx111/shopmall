<%@page import="org.taotaobook.entiy.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名称
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/dtab.css" />
</head>
<body>
	<%
		Manager m = (Manager) request.getSession().getAttribute("manager");
		if (m == null) {
			request.getRequestDispatcher("../Manager/ManagerLogin.jsp").forward(request, response);
		} else {
	%>
	<div class="center-in-center">
		<form action="../ProductsServelt?method=add" method="post"
			enctype="multipart/form-data">
			<table border="1" cellspacing="0">
				<tr>
					<th colspan="2" align="center">添加图书</th>
				</tr>
				<tr>
					<td>图书编号</td>
					<td><input name="id"></td>
				</tr>
				<tr>
					<td>图书名字</td>
					<td><input name="name"></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input name="price"></td>
				</tr>
				<tr>
					<td>作者</td>
					<td><input name="writename"></td>
				</tr>
				<tr>
					<td>图片</td>
					<td><input type="file" name="spicture" /></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input name="description"></td>
				</tr>
				<tr>
					<td>类型</td>
					<td><input name="type"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交">
				</tr>
			</table>
		</form>
		<%
			}
		%>
	</div>
</body>
</html>