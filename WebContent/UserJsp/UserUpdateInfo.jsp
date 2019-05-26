<%@page import="org.taotaobook.entiy.Users"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
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
		Users user = (Users) request.getAttribute("user");
	%>
	<div class="center-in-center">
		<form action="UserSelect?method=update" method="post">
			<table>
				<tr>
					<td>账号:</td>
					<td><input name="pid" value="${user.id}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input name="pname" value="${user.username}" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input name="psex" value="${user.sex}" /></td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td><input type="text" name="pn" value="${user.phonenumber}" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="确定"/></td>
					<td align="center"><a href="ShowProductsInfo">返回</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>