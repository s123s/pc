<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<%--     <h1>${errorMsg}</h1><br>
    
Message:
<%=exception.getMessage()%> --%>
ERROR
<%-- 
StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%> --%>
</body>
</html>