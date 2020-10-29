<jsp:useBean id="user" scope="request" type="pl.arekbednarz.dietcontrolapp.entity.User"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" type="text/css" href="/resources/html/css/styleDashboard.css" media="all">


        </head>

    <header>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="topnav" id="myTopnav">
            <a href="<c:url value='/search'/>" class="active">Strona Główna</a>
            <a href="<c:url value='/search'/>">Wyszukaj posiłek</a>
            <a href="<c:url value='/profile/meals'/>">Dzisiejsze posiłki szczegółowo</a>
            <a href="<c:url value='/addMeal'/>">Dodaj swój posiłek</a>
            <a href="<c:url value='/user_edit'/>">Edycja użytkownika</a>
            <a href="<c:url value='/logout'/>">Wyloguj</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
    </header>
<script type="text/javascript" src="<c:url value="../../../resources/html/js/Dashboard.js" />"></script>









