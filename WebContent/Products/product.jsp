<%@page import="org.taotaobook.entiy.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();//获取项目名称
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/Style/book.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/Style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="top">
		<div class="top_page center">
			<div class="tp_l fl">您好，欢迎来到淘淘书屋</div>
			</br>
		</div>
	<%-- </div>
	<div class="nav center">
		<ul>
			<li><a href="#">书屋首页</a></li>
			<li><a href="#">文学</a></li>
			<li><a href="#">计算机</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#"> <c:if test="${empty user }">
						<li>用户未登录</li>
					</c:if> <c:if test="${not empty user }">
						<li>当前用户:${user.username}</li>
						<li><a
							href='${pageContext.request.contextPath}/user?method=logout'>注销</a>
						</li>
					</c:if>
			</a><s></s></li>
			<li><a href="#">我的购物车</a><s></s></li>
			<li><a href="#">我的订单</a><s></s></li>
		</ul>
	</div> --%>
	<div class="material center">淘淘书屋</div>
	<%
		response.setCharacterEncoding("UTF-8");//设置输出数据的编码格式
		request.setCharacterEncoding("UTF-8");//设置获取数据的编码格式
		//获取request中的数据
		List<Products> list = (List<Products>) request.getAttribute("list");//获取servlet端转发的list数据列表
		for (Products product : list) {
	%>
	<table border="1" align="center" width="600">
		<tr>
			<td><img width="100" height="120"
				src="<%=path%>/<%=product.getImgurl()%>"></td>
			<td width="400">作者：<%=product.getWritename()%></br> 简介：<%=product.getDescription()%></br></td>
		</tr>
		<tr>
			<td><%-- <a href="CartServlet?id=<%=product.getId()%>&method=add" >
 --%>			<input type="button" onclick="window.location.href='UserJsp/UserLogin.jsp'" value="立即购买" class="btn" /></td>
			<td><span><%=product.getPrice()%></span> <s>￥386.00</s></td>
		</tr>

	</table>
	<br />
	<%
		}
	%>

</body>
</html>