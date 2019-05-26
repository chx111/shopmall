<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名称
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/AddStyle.css" />
<script type="text/javascript" src="<%=path%>/Script/jquery-1.10.1.js"></script>
</head>
<body>
	<form action="<%=path%>/UserSelect?method=add" method="post"
		class="Form">
		<table style="margin: 50px auto;">
			<tbody>
				<tr>
					<td>用户账号：</td>
					<td><input type="text" name="user_id" required /></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" name="user_phone"
						pattern="^1[1-9]\d{9}$" title="手机号码有误" /></td>
				</tr>
				<tr>
					<td>用户性别：</td>
					<td><select name="user_sex">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>

				<tr>
					<td>真实姓名：</td>
					<td><input type="text" name="real_name" /></td>
				</tr>
				<tr>
					<td>用户密码：</td>
					<td><input type="password" name="user_pwd" required
						pattern="^\w{6,)$" title="密码长度不能少于6位" /></td>
				</tr>

			</tbody>

			<tfoot>
				<tr>
					<td><input type="submit" value="确定" id="btnSure" /></td>
					<td><input type="reset" value="取消" id="btnCancel" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>
