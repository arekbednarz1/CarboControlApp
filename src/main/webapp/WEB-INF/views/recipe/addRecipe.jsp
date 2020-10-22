<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="../dashboard/header.jsp"/>


<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
            <form:form method="post" modelAttribute="recipe">
                <div class="row border-bottom border-3">
                    <div class="col"><h3 class="color-header text-uppercase">Nowy przepis</h3></div>
                    <div class="col d-flex justify-content-end mb-2">
                        <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                    </div>
                </div>
                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2"><h4>Nazwa Posiłku</h4></th>
                        <td class="col-7">
                            <form:input path="name" type="text" class="w-100 p-1" name="name"
                                        placeholder="nazwa przepisu"/>
                            <form:errors path="name"/>
                        </td>
                        <th scope="row" class="col-2"><h4>Waga Posiłku</h4></th>
                        <td class="col-7">
                            <form:input path="heavy" type="number" class="p-1" name="heavy"
                                        placeholder="waga w gramach"/>
                            <form:errors path="heavy"/>

                        </td>
                    </tr>

                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="../dashboard/footer.jsp"/>