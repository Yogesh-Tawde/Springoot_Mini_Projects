<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty studList}">
		<h1 style="color:red; text-align:center">Student Report</h1>
		<table border="1" bgcolor="cyan" align="center">
			<tr style="color:red">
				<th>sname</th>
				<th>sgrade</th>
				<th>sadd</th>
				<th>scontact</th>
				<th>actions</th>
			</tr>
			
			<c:forEach var="stud" items="${studList}">
				<tr>
					<td>${stud.sname}</td>
					<td>${stud.sgrade}</td>
					<td>${stud.sadd}</td>
					<td>${stud.scontact}</td>
					<td>
                        <a href="/edit_stud?id=${stud.sid}">edit</a>
                        <a href="/delete_stud?id=${stud.sid}" 
                           onclick="return confirm('Do you want to delete this student?')">
                           delete
                        </a>
                    </td>
				</tr>
			
			</c:forEach>
		
		</table>
	</c:when>
	
	<c:otherwise>
		 <h1 style="color:red; text-align:center">Student Not Found</h1>
	</c:otherwise>
</c:choose>	
<h2 style="color:blue; text-align:center">${resultMsg}</h2>
<div style="text-align:center; margin-top:20px;">
    <a href="/add_stud">Add New Student</a>
</div>

