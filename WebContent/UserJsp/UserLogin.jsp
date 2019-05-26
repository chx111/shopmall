<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名称
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登陆</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/Login.css" />
</head>
<body>
	<div class="wrapLogin">
		<div class="loginPanel">
			<form action="<%=path%>/UserSelect?method=login" method="post">
				<h2>欢迎您登陆淘淘书屋</h2>
				<p>
					<label>账号：</label><input type="text" name="user_id" />
				</p>
				<p>
					<label>密码：</label><input type="password" name="user_pwd" />
				</p>
				<p class="btn">
					<input type="submit" class="btnLogin" value="登陆" /> <!-- <a
						herf="UserAdd.jsp"> -->
						<input type="button" class="btnCancel" onclick="window.location.href='UserAdd.jsp'" value="注册">;
					<!-- <input type="button" class="btnCancel"
						value="注册" /></a>
				 --></p>
			</form>
		</div>
	</div>
</body>
</html>