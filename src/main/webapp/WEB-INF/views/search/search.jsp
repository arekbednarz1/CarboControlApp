<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 24.10.2020
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="analytics-main" style="text-align: center">Wyszukaj</h2>
<br>

<hr class="light">

<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-3">
        </div>
        <div class="col-6">
            <div class="card" title="table-card">
                <div class="card-body">
                    <form action="/search" method="get">
                        <fieldset>
                            <div class="panel-group">
                                <div class="panel panel-primary">
                                    <div class="panel-body">
                                        <div class="searchformrow">
                                            <div class="col-md-10 form-group mx-auto">
                                                <label class="form-label">Name:</label>
                                                <input type="text" class="form-control" value="${keyword}"/>
                                            </div>
                                        </div>
                                            <button type="submit" class="btn btn-secondary btn-block">Submit</button>
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
</html>
