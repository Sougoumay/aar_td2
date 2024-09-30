<%--
  Created by IntelliJ IDEA.
  User: elidj
  Date: 30/09/2024
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<form method="post">
    <p>Password: <input type="password" name="password"/></p>
    <p>Password Confirmation: <input type="password" name="password_confirmation" /></p>
    <p><button type="submit" value="ResetPassword" name="TODO"> Envoyer</button></p>
</form>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<jsp:include page="session.jsp"></jsp:include>
</body>
</html>
