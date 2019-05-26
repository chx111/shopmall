<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名称
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淘淘书屋</title>
<link href="<%=path%>/css/Index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/Script/jquery-1.10.1.js"></script>
<script type="text/javascript" src="<%=path%>/Script/Index.js"></script>
</head>
<body>
	
	<div class="header">
		<div class="header_logo">淘淘书屋</div>
	</div>
	<div class="wrap">
		<ul class="siderbar">

			<li><span>用户模式</span>
				<ul>
					<li><a href="<%=path%>/UserJsp/UserLogin.jsp" target="mainFrame">用户登陆</a></li>
					<li><a href="<%=path%>/UserJsp/UserAdd.jsp" target="mainFrame">注册用户信息</a></li>
					<%-- <li><a href="<%=path%>/UserSelect?method=select" target="mainFrame">用户信息查看</a></li>
					<li><a href="<%=path%>/UserSelect?method=select&c=1" target="mainFrame">用户信息更新</a></li>
			 --%>	</ul>
			</li>
			<li><span>全部商品</span>
				<ul>
					<%-- <li><a href="<%=path%>/Order/ShowCar.jsp" target="mainFrame">查看购物车</a></li>
					<li><a href="<%=path%>/orderServlet?method=select" target="mainFrame">查看我的订单</a></li>
			 --%>	
			  <li><a href="<%=path%>/ShowProductsInfo" target="mainFrame">商品推荐</a></li> 
			 </ul>
			
			<li><span>商品分类</span>
				<ul>
					<%-- <li><a href="<%=path%>/ShowProductsInfo" target="mainFrame">商品推荐</a></li> --%>
					<li><a href="<%=path%>/ShowProductsInfo?method=internet"target="mainFrame">计算机类</a></li>
					<li><a href="<%=path%>/ShowProductsInfo?method=novel"  target="mainFrame">小说</a></li>
					<li><a href="<%=path%>/ShowProductsInfo?method=famous" target="mainFrame">经典名著</a></li>
				</ul></li>			
			<%-- <li><span>购物车管理</span>
				<ul>
					<li><a href="<%=path%>/Order/ShowCar.jsp" target="mainFrame">查看购物车</a></li>
					<li><a href="<%=path%>/orderServlet?method=select" target="mainFrame">查看我的订单</a></li>
				</ul>
			</li> --%>
			</li>
			<%-- <li><span>管理员模式</span>
				<ul>
					<li><a href="<%=path%>/Manager/ManagerLogin.jsp" target="mainFrame">管理员登陆</a></li>
					<li><a href="<%=path%>/Manager/addManager.jsp" target="mainFrame">注册管理员</a></li>
					<li><a href="<%=path%>/ManagerServelt?method=select" target="mainFrame">查看个人信息</a></li>
					<li><a href="<%=path%>/ManagerServelt?method=select&c=1" target="mainFrame">管理员信息更新</a></li>
					<li><a href="<%=path%>/Products/addProducts.jsp" target="mainFrame">添加商品</a></li>
					<li><a href="<%=path%>/ProductsServelt?method=select" target="mainFrame">管理商品</a></li>
					<li><a href="<%=path%>/ManagerOrderServlet?method=select" target="mainFrame">订单查看</a></li>
				</ul>
			</li> --%>
		</ul>
		<div class="content">
			<iframe width="99%" height="100%" name="mainFrame" frameborder="0">
			</iframe>
		</div>
	</div>

</body>
</html>