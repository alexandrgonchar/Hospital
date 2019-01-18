<%@ page import="view.Paths" %>

<%@ include file="/WEB-INF/view/includes/header.jsp" %>
<div align="center">
    <form method="post" action=".${Paths.ADD_ASSIGNATIONS_PROCEDURES}">
        <input type="hidden" name="${Parameters.DIAGNOSIS_HISTORY_ID}" value="${diagnosisHistoryId}">
        <table>
            <tr>
                <th>     </th>
                <th><fmt:message key="drugs.days"/></th>
            </tr>
            <c:forEach var="i" items="${proceduresList}">
                <tr>
                    <td> ${i.name} </td>
                    <td><input type="number" name="procedureNumDays_${i.id}"></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit">
    </form>
</div>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>