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
<a href="<c:url value='/profile/meals'/>" class="btn btn-info" role="button">Powrót</a>
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
            <h2 class="analytics-main" style="text-align: center"><c:if test="${pos.size()>0}">${pos.get(0).mealHistory.type}</c:if></h2>

            <br>

            <table class="table table-striped bg-light">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Węglowodany(g)</th>
                    <th scope="col">Waga(g)</th>

                </tr>
                </thead>
                <tbody>


                <c:forEach items="${pos}" var="pos" >
                <tr>
                <td>${pos.name}</td>
                <td>${pos.carbs}</td>
                <td >${pos.heavy}</td>
                </tr>
                </c:forEach>

                <th scope="col">Ilość spożytych węglowodanów : ${carb}(g)  Czyli : ${wym} wymienników węglowodanowych</th>

                </tbody>

            </table>
        </div>
    </div>
</div>

</body>

