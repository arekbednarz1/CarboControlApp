<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container-fluid padding">
<h2 class="analytics-main" style="text-align: center">Wyszukaj produkty</h2>
<br>
    <hr class="light">

    <div class="row padding">
        <div class="col-3">
        </div>
        <div class="col-6">
            <div class="card" title="table-card">
                <div class="card-body">
                    <form action="/searchM" method="">
                        <fieldset>
                            <div class="panel-group">
                                <div class="panel panel-primary">
                                    <div class="panel-body">
                                        <div class="searchformrow">
                                            <div class="col-md-10 form-group mx-auto">
                                                <label class="form-label">Wpisz nazwę:</label>
                                                <input type="text" class="form-control" name="keyword" />
                                            </div>
                                        </div>
                                        <div class="col-md-6 searchformrow mx-auto">
                                            <button type="submit" class="btn btn-secondary btn-block">Wyszukaj</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>



