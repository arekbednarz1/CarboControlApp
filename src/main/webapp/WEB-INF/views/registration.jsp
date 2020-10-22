<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<jsp:include page="header2.jsp"/>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border">
            <div class="container w-25">
                <form:form method="post" modelAttribute="user" class="padding-small text-center">
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <div class="form-group">
                        <form:input path="firstName" type="text" class="form-control" name="firstName" placeholder="podaj imię"/>
                        <form:errors path="firstName"/>
                    </div>
                    <div class="form-group">
                        <form:input path="lastName" type="text" class="form-control" name="lastName" placeholder="podaj nazwisko"/>
                        <form:errors path="lastName"/>
                    </div>
                    <div class="form-group">
                        <form:input path="email" type="text" class="form-control" name="email"
                                    placeholder="podaj adres email"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="form-group">
                        <form:input path="password" type="password" class="form-control" name="password"
                                    placeholder="podaj hasło"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="form-group">
                        <form:input path="passwordRepeat" type="password" class="form-control" name="password"
                                    placeholder="powtórz hasło"/>
                        <form:errors path="passwordRepeat"/>
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>

