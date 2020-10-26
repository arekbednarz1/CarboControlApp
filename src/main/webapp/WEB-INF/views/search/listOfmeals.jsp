<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <meta charset="UTF-8">
    <title>Products</title>

    <!--Bootstrap CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" media="all">


</head>
<body>



<h2 class="analytics-main" style="text-align: center">Wyniki wyszukiwania</h2>

<hr class="light">

<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Węglowodany</th>
                    <th scope="col">Waga</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items ="${mealsList}" var="meal">
                    <tr class="d-flex"> <th scope="row" class="col-1">${meal.id}</th>
                        <td class="col-5">${meal.name}</td>
                        <td class="col-5">${meal.carbs}</td>
                        <td class="col-5">${meal.heavy}</td>

                </tr>
                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</body>
