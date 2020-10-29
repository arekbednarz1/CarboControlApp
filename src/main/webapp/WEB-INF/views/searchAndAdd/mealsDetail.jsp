<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Your Profile</title>

    <!--Bootstrap CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


    <link rel="stylesheet" type="text/css" href="/resources/html/css/style2.css" media="all">

</head>
<body background="../../../resources/html/img/dashboard.jpg">
<a href="<c:url value='/'/>" class="btn btn-info" role="button">Strona Główna</a>
<a href="<c:url value="/search"/>" class="btn btn-info" role="button">Wyszukaj</a>
<body>
<%--<form:form method="post" modelAttribute="dish">--%>
<%--    <form:select path="type">--%>
<%--        <form:option value="Śniadanie" label="Śniadanie"/>--%>
<%--        <form:option value="Drugie śniadanie" label="Drugie śniadanie"/>--%>
<%--        <form:option value="Obiad" label="Obiad"/>--%>
<%--        <form:option value="Podwieczorek" label="Podwieczorek"/>--%>
<%--        <form:option value="Kolacja" label="Kolacja"/>--%>
<%--    </form:select>--%>
<%--</form:form>--%>
<%--<br>--%>
<%--<button type="submit" class="btn btn-secondary">Dodaj</button>--%>
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Dzisiaj zjadłeś</h2>

            <br>

            <table class="table table-striped bg-light">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Węglowodany(g)</th>
                    <th scope="col">Waga(g)</th>

                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${śniadanie}" var="sniadanie" >
                <c:forEach items="${śniadanie}" var="sniadanie" >
                <tr>Śniadanie</tr>
                <td>${sniadanie.name}</td>
                <td>${sniadanie.carbs}</td>
                <td >${sniadanie.heavy}</td>

                </c:forEach>
                </c:forEach>

                <tr>

                    <c:forEach items="${drugieśniadanie}" var="drugiesniadanie" >
<%--            <tr>Drugie śniadanie</tr>--%>
                <td>${drugiesniadanie.name}</td>-Drugie śniadanie
                    <td>${drugiesniadanie.carbs}</td>
                    <td >${drugiesniadanie.heavy}</td>
                </c:forEach>
                </tr>

                    <tr>
                        <thead><tr class="schedules-content-header"> <th scope="row" class="col-1">Obiad</th></thead>
                        <c:forEach items="${obiad}" var="obiad" >
<%--            <tr>Obiad</tr>--%>
                        <td>${obiad.name}</td>-Obiad
                            <td>${obiad.carbs}</td>
                            <td >${obiad.heavy}</td>
                        </c:forEach>
                    </tr>

                    <tr>

                        <c:forEach items="${podwieczorek}" var="podwieczorek" >
<%--                       <tr>Podwieczorek</tr>--%>
                <td>${podwieczorek.name}</td>-Podwieczorek
                        <td>${podwieczorek.carbs}</td>
                        <td >${podwieczorek.heavy}</td>
                        </c:forEach>
                    </tr>

                <tr>

                    <c:forEach items="${kolacja}" var="kolacja" >
<%--            <tr>Kolacja</tr>--%>
                    <td>${kolacja.name}</td>-Kolacja
                    <td>${kolacja.carbs}</td>
                    <td >${kolacja.heavy}</td>
                </c:forEach>
                </tr>

                </tbody>

            </table>
        </div>
    </div>
</div>

</body>

