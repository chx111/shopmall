<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.taotaobook.entiy.Products"%>
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
		Products product = (Products) request.getAttribute("product");
	%>
	<div class="center-in-center">
	<form action="ProductsServelt?method=update" method="post"">
	
	<table border="1">
		<tr>
			<td>编号：</td>
			<td><input name="pid" value="<%=product.getId()%>"></td>
		</tr>
		<tr>
			<td>名字：</td>
			<td><input name="pname" value="<%=product.getName()%>"></td>
		</tr>
		<tr>
			<td>作者:</td>
			<td><input name="pwritename" value="<%=product.getWritename()%>"></td>
		</tr>
		<tr>
			<td>价格:</td>
			<td><input name="pprice" value="<%=product.getPrice()%>"></td>
		</tr>
		<tr>
			<td>图片地址:</td>
			<td><input name="pimgurl" value="<%=product.getImgurl()%>"></td>
		</tr>
		<tr>
			<td>类型:</td>
			<td><input name="ptype" value="<%=product.getType()%>"></td>
		</tr>
		<tr>
			<td>简介：</td>
			<td><textarea rows="4" cols="20" name="pdescription"><%=product.getDescription()%> </textarea></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="确定"/></td>
			<td><button type="button">
					<a href="ProductsServelt?method=select">返回</a>
				</button></td>
		</tr>
	</table>
	
	</form>
</div>


</body>
</html>