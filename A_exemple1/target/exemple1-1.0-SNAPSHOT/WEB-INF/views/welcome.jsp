<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
Bienvenue, ${username}.

<form action="${pageContext.request.contextPath}/logout">
    <button type="submit">se déconnecter</button>
</form>

<form action="${pageContext.request.contextPath}/simplecheck">
    <button type="submit">Vérifier le login en session (en trace de serveur)</button>
</form>

<jsp:include page="session.jsp"></jsp:include>


</body>
</html>
