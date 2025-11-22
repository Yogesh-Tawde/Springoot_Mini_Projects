<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty prodList}">
		<h1 style="color:red; text-align:center">Product Details</h1>
		<table border="1" bgcolor="cyan" align="center">
			<tr style="color:red">
				<th>pid</th>
				<th>pname</th>
				<th>pcat</th>
				<th>pmanfac</th>
				<th>pprice</th>
				<th>actions</th>
			</tr>
			
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td>${prod.pid}</td>
					<td>${prod.pname}</td>
					<td>${prod.pcat}</td>
					<td>${prod.pmanfac}</td>
			        <td>${prod.pprice}</td>			
					<td>
                        <a href="/editProd?pid=${prod.pid}">edit</a>
                        <a href="/deleteProd?pid=${prod.pid}" 
                           onclick="return confirm('Do you want to delete this student?')">
                           delete
                        </a>
                    </td>
				</tr>
			
			</c:forEach>
		
		</table>
	</c:when>
	
	<c:otherwise>
		 <h1 style="color:red; text-align:center">Product Not Found</h1>
	</c:otherwise>
</c:choose>	
<h2 style="color:blue; text-align:center">${resultMsg}</h2>
<div style="text-align:center; margin-top:20px;">
    <a href="/add_prod">Add New Product</a>
</div>

