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

    <link rel="stylesheet" type="text/css" href="/static/style.css" media="all">

</head>
<body style="background-color: bisque">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Strona główna</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

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
<%--                    <form:form action="/food_remove" method="post" modelAttribute="mealHistory">--%>
<%--                        <tr class="d-flex"> <th scope="row" class="col-1">${food.id}</th>--%>
<%--                        <form:hidden path="recipe" value="${food}"/>--%>
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

<div class="updateGoalsAddFood">
    Kliknij aby wyszukać i dodać nowy posiłek:
    <br>
    <br>
    <a href="<c:url value="/search"/>" class="btn btn-info rounded-0 text-light">Dodaj</a>
</div>


</body>