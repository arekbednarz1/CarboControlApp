<jsp:useBean id="user" scope="request" type="pl.arekbednarz.dietcontrolapp.entity.User"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>






<head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" type="text/css" href="/resources/html/css/style4.css" media="all">


        </head>
    <body>
    <header class="page-header">
        <div id="navbar">
            <a id="logo">${user.firstName} ${user.lastName}</a>
            <div id="navbar-right">
                <a class="active" href="<c:url value='/'/>">Strona Główna</a>
                <a href="<c:url value='/search'/>">Wyszukaj posiłek</a>
                <a href="<c:url value='/profile/meals'/>">Dzisiejsze posiłki szczegółowo</a>
                <a href="<c:url value='/user_edit'/>">Edycja użytkownika</a>
                <a href="<c:url value='/logout'/>">Wyloguj</a>
            </div>
        </div>



        <script>
            window.onscroll = function() {scrollFunction()};

            function scrollFunction() {
                if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
                    document.getElementById("navbar").style.padding = "30px 10px";
                    document.getElementById("logo").style.fontSize = "25px";
                } else {
                    document.getElementById("navbar").style.padding = "80px 10px";
                    document.getElementById("logo").style.fontSize = "35px";
                }
            }
        </script>

        </div>
    </header>
    <section class="dashboard-section">
        <div class="row dashboard-nowrap">



</div>
    </section>

