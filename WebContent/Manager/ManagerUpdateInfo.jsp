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
	<div class="center-in-center">
		<form action="ManagerServelt?method=update" method="post">
			<table>
				<tr>
					<td>账号:</td>
					<td><input name="pid" value="${manager.idcard}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input name="pname" value="${manager.mname}" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input name="psex" value="${manager.msex}" /></td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td><input type="text" name="pn"
						value="${manager.mphonenumber}" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="确定"/></td>
					<td align="center"><a href="ProductsServelt?method=select">返回</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>