<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Products</title>--%>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquerySearch.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        $(document).ready(function (){--%>
<%--            $('#checkBoxAll').click(function (){--%>
<%--                if ($(this).is(":checked"))--%>
<%--                    $('.chkCheckBoxId').prop('checked', true);--%>
<%--                else--%>
<%--                    $('.chkCheckBoxId').prop('checked',false);--%>
<%--            });--%>
<%--        });--%>
<%--//     </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2 class="analytics-main" style="text-align: center">Wyniki wyszukiwania</h2>--%>
<%--<table cellpadding="2" cellspacing="2" border="1">--%>
<%--                <tr>--%>

<%--                    --%>
<%--                    <th scope="col">Nazwa</th>--%>
<%--                    <th scope="col">Węglowodany(g)</th>--%>
<%--                    <th scope="col">Waga(g)</th>--%>
<%--                    <th scope="col"></th>--%>
<%--                </tr>--%>
<%--                <c:forEach items ="${mealsList}" var="meal">--%>
<%--                    <tr class="d-flex"> <th scope="row" class="col-1">${meal.id}</th>--%>
<%--                        <td>${meal.name}</td>--%>
<%--                        <td>${meal.carbs}</td>--%>
<%--                        <td >${meal.heavy}</td>--%>
<%--                        <td class="col-1"><a href="<c:url value="/meals/${meal.id}"/>" class="btn btn-info rounded-0 text-light">Dodaj</a></td>--%>
<%--                </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</body>--%>

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

<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Wyniki wyszukiwania</h2>
            <form:form method="post" modelAttribute="dish" action="/addToHistory">

            <br>

            <table class="table table-striped bg-light">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Węglowodany(g)</th>
                    <th scope="col">Waga(g)</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${mealsList}" var="meal">
                        <td><form:input path="recipe.name" type="text" value="${meal.name}" readonly="true"/></td>
                <td>
                    <form:input path="recipe.carbs" type="text" value="${meal.carbs}" readonly="true"/></td>

                    <td>
                        <form:input type="number" min="1" path="heavy" value="${meal.heavy}" /></td>

                    <td>
                            <form:select path="type">
                                <form:option value="Śniadanie" label="Śniadanie"/>
                                <form:option value="Drugie śniadanie" label="Drugie śniadanie"/>
                                <form:option value="Obiad" label="Obiad"/>
                                <form:option value="Podwieczorek" label="Podwieczorek"/>
                                <form:option value="Kolacja" label="Kolacja"/>
                            </form:select>
                    </td>
                    <td><button type="submit" class="btn btn-secondary">Submit</button></td>
                </c:forEach>

                    </tr>
                </form:form>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
