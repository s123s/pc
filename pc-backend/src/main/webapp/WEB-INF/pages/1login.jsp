<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Login page</h1>
	<FORM method="post" name="theForm" action="/j_spring_security_check">
	name<input type="input" name="j_username" value="" /> <BR>
	pass<input type="hidden" name="j_password" value="" />
	<input type="hidden" name="_spring_security_remember_me" value="" >Remember me
	<input type="submit" value="Отправить">
	</FORM>

</body>
</html>