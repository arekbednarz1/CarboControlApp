<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<body>
<header class="page-header">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                font-family: "Lato", sans-serif;
            }

            .sidebar {
                height: 100%;
                width: 0;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #111;
                overflow-x: hidden;
                transition: 0.5s;
                padding-top: 60px;
            }

            .sidebar a {
                padding: 8px 8px 8px 32px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
                transition: 0.3s;
            }

            .sidebar a:hover {
                color: #f1f1f1;
            }

            .sidebar .closebtn {
                position: absolute;
                top: 0;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
            }

            .openbtn {
                font-size: 20px;
                cursor: pointer;
                background-color: #111;
                color: white;
                padding: 10px 15px;
                border: none;
            }

            .openbtn:hover {
                background-color: #444;
            }

            #main {
                transition: margin-left .5s;
                padding: 16px;
            }


            @media screen and (max-height: 450px) {
                .sidebar {padding-top: 15px;}
                .sidebar a {font-size: 18px;}
            }
        </style>
    </head>
    <body>

    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
        <a href="<c:url value='/login'/>">Logowanie</a>
        <a href="<c:url value='/register'/>">Rejestracja</a>
    </div>

    <div id="main">
        <button class="openbtn" onclick="openNav()">Kontroluj cukrzycę</button>
    </div>

    <script>
        function openNav() {
            document.getElementById("mySidebar").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
            document.getElementById("main").style.marginLeft= "0";
        }
    </script>

    </body>

</header>

<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">--%>
<%--    <div class="container">--%>
<%--        <a class="navbar-brand" href="<c:url value='/'/>">--%>
<%--            Kontroluj <span>cukrzyce</span>--%>
<%--        </a>--%>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarResponsive">--%>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item">--%>
<%--                    <<a class="nav-link" href="<c:url value='/register'/>">rejestracja</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="<c:url value='/login'/>">logowanie</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>



<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">--%>
<%--    <div class="container">--%>
<%--        <a class="navbar-brand" href="<c:url value='/'/>">--%>
<%--            Kontroluj <span>cukrzyce</span>--%>
<%--        </a>--%>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarResponsive">--%>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item active">--%>
<%--                    <<a class="nav-link" href="<c:url value='/register'/>">rejestracja</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link color-header" href="<c:url value='/login'/>">logowanie</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<%--<!-- Page Content -->--%>
<%--<div class="container">--%>
<%--    <h1 class="mt-4">Logo Nav by Start Bootstrap</h1>--%>
<%--    <p>The logo in the navbar is now a default Bootstrap feature in Bootstrap 4! Make sure to set the width and height of the logo within the HTML or with CSS. For best results, use an SVG image as your logo.</p>--%>
<%--</div>--%>


<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">--%>
<%--    <div class="container">--%>
<%--        <a class="navbar-brand" href="<c:url value='/'/>">--%>
<%--            Kontroluj <span>cukrzyce</span>--%>
<%--        </a>--%>
<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="true" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="navbar-collapse collapse show" id="navbarResponsive" style="">--%>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item active">--%>
<%--                    <a class="nav-link" href="#">Home--%>
<%--                        <span class="sr-only">(current)</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link color-header" href="<c:url value='/register'/>">rejestracja</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link color-header" href="<c:url value='/login'/>">logowanie</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#">Contact</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>





