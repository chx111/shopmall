<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.taotaobook.entiy.Products"%>
<%@page import="java.util.List"%>
<%
	String path=request.getContextPath();//获取项目名称
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="<%=path %>/Script/jquery-1.10.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function delConfirm(e){
	var flag=window.confirm("确认删除商品吗");
	if(!flag){
		
		if(e&&e.preventDefault){
			e.preventDefault();
		}else{
			window.event.returnValue = false;
		}
	}
}
</script>
</head>
<body>
	<table border="1" cellspacing="0">
		<thead>
			<tr>
				<th>书id值</th>
				<th>书名</th>
				<th>作者</th>
				<th>价钱</th>
				<th>图片地址</th>
				<th width="600px">简介</th>
				<th >类型</th>
				<th>操作</th>
			</tr>
		</thead>

		<tbody>
			<%
			response.setCharacterEncoding("UTF-8");//设置输出数据的编码格式
			request.setCharacterEncoding("UTF-8");//设置获取数据的编码格式
			//获取request中的数据
			List<Products> list = (List<Products>) request.getAttribute("list");//获取servlet端转发的list数据列表
				for(Products product:list){
			%>
				<tr>
					<td><%=product.getId() %></td>
					<td><%=product.getName() %></td>
					<td><%=product.getWritename()%></td>
					<td><%=product.getPrice() %></td>
					<td><%=product.getImgurl() %></td>
					<td width="600px"><%=product.getDescription() %></td>
					<td><%=product.getType() %></td>
					<td><a href="deleteProduct?id=<%=product.getId()%>" onclick="delConfirm(event)">下架</a>&nbsp&nbsp&nbsp<a href="updateProduce?id=<%= product.getId() %>">更新</a><td>
				</tr>
			<%
				}
			
			%>
		</tbody>	
	</table>
</body>
</html>