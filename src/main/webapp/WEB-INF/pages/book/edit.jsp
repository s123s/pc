<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>edit book</h2>

	<FORM method="post" name="theForm" action="../../book/save_edited" accept-charset="UTF-8">

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
		id<input type="input" name="id" readonly="readonly" value="${book.id}" /> <BR>
		name<input type="input" name="name" value="${book.name}" /> <BR>
		isdn<input type="input" name="isdn" value="${book.isdn}" /> <BR>
		autor_id<input type="input" name="autorId" value="${book.autorId}" /> <BR>
			<input type="submit" value="Сохранить">
	</FORM>
</body>
</html>
