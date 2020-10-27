<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

    <!--Bootstrap CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/resources/html/css/style2.css" media="all">

</head>
<body style="background-color: bisque">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Strona główna</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>


<div class="container-fluid padding">

    <h2 class="analytics-main" style="text-align: center">Edytuj Użytkownika</h2>

    <hr class="light">

    <br>

    <div class="row padding">
        <div class="col-3">
        </div>
        <div class="col-6">
            <div class="card" title="table-card">
                <div class="card-body">

                    <form:form method="post" modelAttribute="user" class="padding-small text-center">
                        <div class="form-group">
                            <form:input path="firstName" type="text" class="form-control" name="firstName" value="${user.firstName}"/>
                            <form:errors path="firstName"/>
                        </div>
                        <div class="form-group">
                            <form:input path="lastName" type="text" class="form-control" name="lastName" value="${user.lastName}"/>
                            <form:errors path="lastName"/>
                        </div>
                        <div class="form-group">
                            <form:input path="email" type="text" class="form-control" name="email"
                                        value="${user.email}"/>
                            <form:errors path="email"/>
                        </div>
                        <div class="form-group">
                            <form:input path="password" type="password" class="form-control" name="password"
                                        value="${user.password}"  placeholder="hasło"/>
                            <form:errors path="password"/>
                        </div>
                        <button class="btn btn-color rounded-0" type="submit">Edytuj</button>
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