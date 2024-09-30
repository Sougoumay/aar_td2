<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenue</title>
</head>
<body>

<span>Bienvenue ${username}</span>.

<form method="post">
    <button type="submit" name="TODO" value="Logout">se déconnecter</button>
</form>

<form method="post">
    <button type="submit" name="TODO" value="ChangePassword">Changer votre mot de passe</button>
</form>

<form method="post">
    <button type="submit" name="TODO" value="SimpleCheck">Vérifier le login en session (en trace de serveur)</button>
</form>

<c:if test="${not empty message}"><span style="color: blue">${message}</span></c:if>

<jsp:include page="session.jsp"></jsp:include>



</body>
</html>
