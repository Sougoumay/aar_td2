<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Identification</title>
</head>
<body>
<h1>IDENTIFICATION</h1>

<c:if test="${not empty error}">
    <p><label style="color:red">${error}</label></p>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>login <input type="text" name="login"/></p>
    <p>mot de passe <input type="password" name="password"/></p>
    <p><button type="submit">Envoyer</button></p>
</form>


<c:import url="session.jsp"></c:import>

</body>
</html>
