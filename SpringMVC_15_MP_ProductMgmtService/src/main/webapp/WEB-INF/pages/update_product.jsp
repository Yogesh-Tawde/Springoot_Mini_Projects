<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:blue;text-align:center">Edit Product Details</h1>
<frm:form modelAttribute="prod">

	<table border="1" align="center" bgcolor="cyan">
		<frm:hidden path="updateCount"/>
		<tr>
			<td>Product id</td>
			<td><frm:input path="pid"/></td>
		</tr>
		
		<tr>
			<td>Product Name</td>
			<td><frm:input path="pname"/></td>
		</tr>
		
		<tr>
			<td>Product Category:</td>
			<td><frm:input path="pcat"/></td>
		</tr>
		
		<tr>
			<td>Product Manufacturer: </td>
			<td><frm:input path="pmanfac"/></td>
		</tr>
		
		<tr>
			<td>Product Price:</td>
			<td><frm:input path="pprice"/></td>
		</tr>
		
		<tr>
			<td>Actions</td>
			<td><frm:input path="pprice"/></td>
		</tr>
		
		<tr>
    			<td><input type="submit" value="Edit Product"></td>
    			<td><input type="reset" value="Cancel"></td>
		</tr>	
	</table>

</frm:form>
