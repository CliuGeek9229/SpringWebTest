<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>~~欢迎登陆~~</title>
	</head>
	<body>
		<center><h2>管理员登录程序</h2></center>
	<center>
		<c:if test="${!empty error }">
			<font color = "red"><c:out value="${ error }" /></font>
		</c:if>
		<form action="<c:url value="/loginCheck.html"/>" method="post">
			用户名：
			<input type="text" name="userName">
			<br>
			密码：
			<input type="password" name="password">
			<br>
			<input type="submit" value="登录"/>
			<input type="reset" value="重置"/>
		</form>
	</center>
	</body>
</html>