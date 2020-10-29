<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<body>
<header class="page-header">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="/resources/html/css/style3.css" media="all">

    </head>
    <body>

    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
        <a href="<c:url value='/login'/>">Logowanie</a>
        <a href="<c:url value='/register'/>">Rejestracja</a>
    </div>

    <div id="main">
        <button class="openbtn" onclick="openNav()">Menu</button>
    </div>


    <script type="text/javascript" src="<c:url value="../../resources/html/js/login.js" />"></script>

    </body>

</header>



