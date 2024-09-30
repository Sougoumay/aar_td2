<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="display:block; border: solid thin darkblue;">
Le login stocké en session est :
<c:if test="${ not empty sessionScope.courant}">
    ${sessionScope.courant}
</c:if>
<c:if test="${ empty sessionScope.courant}">
    Pas de login stocké en session
</c:if>
</div>