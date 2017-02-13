<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <title>Title Login Page</title>
</head>

<body>
<div class ="container">
    <h2> Hello bro, please Sign in </h2>
    <div>
        <br>
        <br>
        <br>
        <div class ="container">
            <form>
                <div class="form-group">
                    <label for="login"> Login</label>
                    <input type="text" name="login" id="login" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password"> Password</label>
                    <input type="password" name= "password" class="form-control">
                </div>
                <button type="submit"class="btn btn-primary">Send</button>
            </form>


            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            </div>
        </div>
    </div>
</body>
</html>
<%--
<body>
<h1>Login page</h1>
<p>Valid users:
<p>username: <b>user</b>, password: <b>user</b></p>
<p>username: <b>admin</b>, password: <b>admin</b></p>
<p>username: <b>guest</b>, password: <b>guest</b></p>

<c:if test="${not empty param.login_error}">
  <span style="color: red; ">
    Your login attempt was not successful, try again.<br/><br/>
    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
  </span>
</c:if>

<form name="frm" action="/login" method="post">
    <table>
        <tr> <td>User:</td> <td><input type="text" name="username"></td></tr>

        <tr><td>Password:</td> <td><input type="password" name="password"></td></tr>

        <tr><td colspan="2"><input type="submit"></td></tr>
        <tr><td colspan="2"><input  type="reset"></td></tr>
    </table>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>

</body>

</html>
--%>
