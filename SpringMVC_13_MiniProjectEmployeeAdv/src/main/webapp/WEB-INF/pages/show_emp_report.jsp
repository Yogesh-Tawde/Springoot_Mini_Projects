<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${!empty empList}">
        <h1 style="color:red; text-align:center">Employee Report</h1>
        
        <table border="1" align="center" bgcolor="cyan">
            <tr style="color:red">
                <th>ename</th>
                <th>edeg</th>
                <th>eadd</th>
                <th>esal</th>
                <th>emobile</th>
                <th>actions</th>
            </tr>

            <c:forEach var="emp" items="${empList}">
                <tr>
                    <td>${emp.ename}</td>
                    <td>${emp.edeg}</td>
                    <td>${emp.eadd}</td>
                    <td>${emp.esal}</td>
                    <td>${emp.emobile}</td>
                    <td>
                        <a href="/edit_emp?id=${emp.eid}">edit</a>
                        <a href="/delete_emp?id=${emp.eid}" 
                           onclick="return confirm('Do you want to delete this employee?')">
                           delete
                        </a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:when>

    <c:otherwise>
        <h1 style="color:red; text-align:center">Employee Not Found</h1>
    </c:otherwise>
</c:choose>

<h2 style="color:blue; text-align:center">${resultMsg}</h2>
<div style="text-align:center; margin-top:20px;">
    <a href="/add_emp">Add New Employee</a>
</div>

