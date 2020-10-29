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
<a href="<c:url value="/search"/>" class="btn btn-info" role="button">Wyszukaj kolejny</a>

<h2 class="analytics-main" style="text-align: center">${welcomeMessage}</h2>

<hr class="light">

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
                <c:forEach items="${mealsConsumedToday}" var="food" >
                <tr>
                <thead><tr class="schedules-content-header"> <th scope="row" class="col-1">${food.type}</th></thead>
                        <td>${food.recip.name}</td>
                        <td>${food.recip.carbs}</td>
                        <td >${food.heavy}</td>

                </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>




</body>