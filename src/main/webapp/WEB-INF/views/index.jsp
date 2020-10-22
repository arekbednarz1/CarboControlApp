<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<c:if test="${logged_user == null}">
    <jsp:include page="login.jsp"/>
</c:if>
<c:if test="${logged_user != null}">
    <jsp:include page="dashboard/main.jsp"/>
</c:if>