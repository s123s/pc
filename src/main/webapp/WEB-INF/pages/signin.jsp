<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<title>Sign In</title>
<style type="text/css">
#login_div {
	border: 1px solid;
	padding: 5px;
	width: 200px;
	height: 100px;
}
</style>
</head>
<body>
	<h5>Войти в систему</h5>
	<div style="color: red">${message}</div>
	<div id="login_div">
		<form class="login-form" action="login" method="post">

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> 
				<label for="username">User: </label><br>
				<input id="username" name="username" size="20" maxlength="50" type="text" /><br>

				<label for="password">Password: </label><br>
				<input id="password" name="password" size="20" maxlength="50" type="password" /><br>
				<!-- <input type="submit" value="Login" /> -->
				<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>