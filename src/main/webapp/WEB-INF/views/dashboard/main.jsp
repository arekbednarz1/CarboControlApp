<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


        <div class="dashboard-alerts">
            <div class="alert-item alert-info">
                <i class="fas icon-circle fa-info-circle"></i>
                <span class="font-weight-bold">Liczba dodanych posiłków: ${recipes_count}</span>
            </div>

        </div>
    </div>
    <div class="m-4 p-4 border-dashed">
                <tbody>
                <c:forEach var="dto" items="${entry.value}">
                    <tr class="d-flex">
                        <td class="col-2">${dto.mealName}</td>
                        <td class="col-8">${dto.recipeName}</td>
                        <td class="col-2">
                            <a href="<c:url value='/recipes/${dto.recipeId}'/>">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>

