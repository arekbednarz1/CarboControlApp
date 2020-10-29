<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<c:if test="${pos.size() == 0}">
    <jsp:include page="errorDish.jsp"/>
</c:if>
<c:if test="${pos.size() != 0}">
    <jsp:include page="mealsDetail.jsp"/>
</c:if>