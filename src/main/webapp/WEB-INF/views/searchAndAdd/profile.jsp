<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title></title>

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

                <c:forEach items="${foodConsumedToday}" var="food">
                <tr>
<%--                    <form:form action="/food_remove" method="post" modelAttribute="mealHistory">--%>
<%--                        <tr class="d-flex"> <th scope="row" class="col-1">${food.id}</th>--%>
<%--                        <form:hidden path="recip" value="${food}"/>--%>
                        <td>${food.name}</td>
                        <td>${food.carbs}</td>
                        <td >${food.heavy}</td>
<%--                        <td><form:select id = "posiłek" name = "posiłek" path="type">--%>
<%--                        <form:option value = "Śniadanie">Śniadanie</form:option>--%>
<%--                        <option value = "Drugie śniadanie">Drugie śniadanie</option>--%>
<%--                        <option value = "Obiad">Obiad</option>--%>
<%--                        <option value = "Podwieczorek">Podwieczorek</option>--%>
<%--                        <option value = "Kolacja">Kolacja</option></form:select>--%>
<%--                        </td>--%>

<%--                        <td><button type="submit" value="Dodaj do posiłku"/></td>--%>
<%--                    </form:form>--%>
                </tr>
    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


<%--<th scope="col">zaznacz</th>--%>
<%--<th scope="col">Nazwa</th>--%>
<%--<th scope="col">Węglowodany(g)</th>--%>
<%--<th scope="col">Waga(g)</th>--%>
<%--<th scope="col"></th>--%>
<%--</tr>--%>
<%--<c:forEach items ="${mealsList}" var="meal">--%>
<%--<tr class="d-flex"> <th scope="row" class="col-1">${meal.id}</th>--%>
<%--    <td>${meal.name}</td>--%>
<%--    <td>${meal.carbs}</td>--%>
<%--    <td >${meal.heavy}</td>--%>
<%--    <td class="col-1"><a href="<c:url value="/meals/${meal.id}"/>" class="btn btn-info rounded-0 text-light">Dodaj</a></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>


</body>