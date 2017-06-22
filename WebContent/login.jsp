<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body bgcolor="#e3e3e3">
	<form action="mainServlet" method="post">
		<table align = "center">
			<tr align = "center">
				<td>用户名：</td>
				<td><input type="text" name="username" size="20" /></td>
			</tr>
			<tr align = "center">
				<td align = "right">密码：</td>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
			<tr align = "center">
				<td><input type="submit" value="登陆"></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	<a href="register.jsp">点击注册</a>
</body>
</html>