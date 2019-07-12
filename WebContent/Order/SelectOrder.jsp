<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<br/>
	<div align="center">
		<font size="5">订单信息</font>
	</div>
	<br/>
	<table align="center" border="1">
		<tr>
			<td>订单编号</td>
			<td>订单信息</td>
			<td>订单状态</td>
			<td>订单用户</td>
		</tr>

		<c:forEach items="${lits}" var="lits">
			<tr>
				<td>${lits.id}</td>
				<td>
					<table align="center" border="1">
						<tr>
							<td>商品名称</td>
							<td>商品单价</td>
							<td>购买数量</td>
						</tr>

						<c:forEach items="${lits.it}"  var="it">
							<tr>
								<td>${it.name}</td>
								<td>${it.price}</td>
								<td>${it.num}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="3" align="right">总价:${lits.money}</td>
						</tr>

					</table>
			</td>
			<td><c:if test="${lits.paystate==0}">
						未处理
				</c:if> <c:if test="${lits.paystate==1}">
						已处理
					</c:if></td>
			<td>${lits.user_id}</td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>
