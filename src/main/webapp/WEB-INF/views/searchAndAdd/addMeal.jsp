<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 25.10.2020
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<jsp:include page="../dashboard/header.jsp"/>--%>


<%--<div class="m-4 p-3 width-medium">--%>
<%--    <div class="dashboard-content border-dashed p-3 m-4 view-height">--%>
<%--        <div class="row border-bottom border-3 p-1 m-1">--%>
<%--            <form:form method="post" modelAttribute="meal">--%>
<%--            <div class="col noPadding">--%>
<%--                <h3 class="color-header text-uppercase">Nowy posiłek</h3>--%>
<%--            </div>--%>

<%--            <div class="col d-flex justify-content-end mb-2 noPadding">--%>
<%--                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="schedules-content">--%>
<%--            <div class="form-group row">--%>
<%--                <label for="mealName" class="col-sm-2 label-size col-form-label">--%>
<%--                    Nazwa--%>
<%--                </label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <form:input path="name" type="text" class="form-control" name="name" id="mealName"--%>
<%--                                placeholder="Nazwa posiłku"/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="carbs" class="col-sm-2 label-size col-form-label">--%>
<%--                    Węglowodany--%>
<%--                </label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <form:input type="number" min="1" class="form-control" id="carbs"--%>
<%--                                   path="carbs"/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="carbs" class="col-sm-2 label-size col-form-label">--%>
<%--                   Waga--%>
<%--                </label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <form:input type="number" min="1" class="form-control" id="heavy"--%>
<%--                                   path="heavy"/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            </form:form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</section>--%>





<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

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

    <h2 class="analytics-main" style="text-align: center">Dodaj nowy posiłek</h2>

    <hr class="light">

    <br>

    <div class="row padding">
        <div class="col-3">
        </div>
        <div class="col-6">
            <div class="card" title="table-card">
                <div class="card-body">

                    <form:form method="post" modelAttribute="meal">
                        <div class="container center_div">
                            <div class="col-md-6 form-group">
                                <label>Nazwa:</label>
                                <form:input path="name" type="text" class="form-control" name="name" id="mealName"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Węglowodany:</label>
                                <form:input type="number" min="1" class="form-control" id="carbs" path="carbs"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Waga:</label>
                                <form:input type="number" min="1" class="form-control" id="heavy" path="heavy"/>
                            </div>
                            <form:form method="post" modelAttribute="dish">
                                <form:select path="type">
                                    <form:option value="Śniadanie" label="Śniadanie"/>
                                    <form:option value="Drugie śniadanie" label="Drugie śniadanie"/>
                                    <form:option value="Obiad" label="Obiad"/>
                                    <form:option value="Podwieczorek" label="Podwieczorek"/>
                                    <form:option value="Kolacja" label="Kolacja"/>
                                </form:select>
                            </form:form>
                            <br>
                            <button type="submit" class="btn btn-secondary">Dodaj</button>
                        </div>
                    </form:form>
                </div>
            </div>

            </form>
        </div>
    </div>
</div>
</div>
</div>
</body>

</html>