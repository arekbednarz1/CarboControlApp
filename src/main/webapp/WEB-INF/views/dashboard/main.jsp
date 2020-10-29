<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/html/css/style4.css'/>">
<jsp:include page="header.jsp"/>
<body>
<div class="hero-image">
    <div class="hero-text">
        <h1>Witaj ${user.firstName} ${user.lastName}</h1>
        <p>Dodaj nowy posiłek do swojego dnia</p>
        <a href="<c:url value='/addMeal'/>" class="btn btn-info" role="button">Dodaj</a>
    </div>
</div>
</body>