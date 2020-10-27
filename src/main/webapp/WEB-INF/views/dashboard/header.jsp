<jsp:useBean id="user" scope="request" type="pl.arekbednarz.dietcontrolapp.entity.User"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!DOCTYPE html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            * {box-sizing: border-box;}

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            #navbar {
                overflow: hidden;
                background-color: #f1f1f1;
                padding: 90px 10px;
                transition: 0.4s;
                position: fixed;
                width: 100%;
                top: 0;
                z-index: 99;
            }

            #navbar a {
                float: left;
                color: black;
                text-align: center;
                padding: 12px;
                text-decoration: none;
                font-size: 18px;
                line-height: 25px;
                border-radius: 4px;
            }

            #navbar #logo {
                font-size: 35px;
                font-weight: bold;
                transition: 0.4s;
            }

            #navbar a:hover {
                background-color: #ddd;
                color: black;
            }

            #navbar a.active {
                background-color: dodgerblue;
                color: white;
            }

            #navbar-right {
                float: right;
            }

            @media screen and (max-width: 580px) {
                #navbar {
                    padding: 20px 10px !important;
                }
                #navbar a {
                    float: none;
                    display: block;
                    text-align: left;
                }
                #navbar-right {
                    float: none;
                }
            }
        </style>
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
    <div style="margin-top:200px;padding:15px 15px 50px;font-size:30px">
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














<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>

<%--<head>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, Helvetica, sans-serif;--%>
<%--            margin: 0;--%>
<%--        }--%>

<%--        .navbar {--%>
<%--            overflow: hidden;--%>
<%--            background-color: #333;--%>
<%--        }--%>

<%--        .navbar a {--%>
<%--            float: left;--%>
<%--            font-size: 16px;--%>
<%--            color: white;--%>
<%--            text-align: center;--%>
<%--            padding: 14px 16px;--%>
<%--            text-decoration: none;--%>
<%--        }--%>

<%--        .subnav {--%>
<%--            float: left;--%>
<%--            overflow: hidden;--%>
<%--        }--%>

<%--        .subnav .subnavbtn {--%>
<%--            font-size: 16px;--%>
<%--            border: none;--%>
<%--            outline: none;--%>
<%--            color: white;--%>
<%--            padding: 14px 16px;--%>
<%--            background-color: inherit;--%>
<%--            font-family: inherit;--%>
<%--            margin: 0;--%>
<%--        }--%>

<%--        .navbar a:hover, .subnav:hover .subnavbtn {--%>
<%--            background-color: gray;--%>
<%--        }--%>

<%--        .subnav-content {--%>
<%--            display: none;--%>
<%--            position: absolute;--%>
<%--            left: 0;--%>
<%--            background-color: gray;--%>
<%--            width: 100%;--%>
<%--            z-index: 1;--%>
<%--        }--%>

<%--        .subnav-content a {--%>
<%--            float: left;--%>
<%--            color: white;--%>
<%--            text-decoration: none;--%>
<%--        }--%>

<%--        .subnav-content a:hover {--%>
<%--            background-color: #eee;--%>
<%--            color: black;--%>
<%--        }--%>

<%--        .subnav:hover .subnav-content {--%>
<%--            display: block;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class="navbar">--%>
<%--    <a href="<c:url value='/'/>">Strona główna</a>--%>
<%--    <a href="<c:url value='/logout'/>">Wyloguj</a>--%>
<%--    <div class="subnav">--%>
<%--        <button class="subnavbtn">Opcje <i class="fa fa-caret-down"></i></button>--%>
<%--        <div class="subnav-content">--%>
<%--            <a href="<c:url value='/recipes'/>">Posiłki</a>--%>
<%--            <a href="<c:url value='/plans'/>">Całodniowe plany</a>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</div>--%>

<%--<div style="padding:0 16px">--%>
<%--    <div class="d-flex justify-content-around">--%>
<%--        <h4 class="text-light mr-3">${user.firstName} ${user.lastName}</h4>--%>
<%--        <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>







