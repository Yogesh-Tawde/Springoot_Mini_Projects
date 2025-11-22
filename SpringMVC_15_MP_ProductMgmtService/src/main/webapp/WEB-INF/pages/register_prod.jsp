<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Add New Product</h1>

<frm:form modelAttribute="prod">


<table align="center" bgcolor="cyan" border="1">

    <tr>
        <td>Product Name:</td>
        <td><frm:input path="pname"/></td>
    </tr>
    
    <tr>
        <td>Product Catagory:</td>
        <td><frm:input path="pcat"/></td>
    </tr>
    
    <tr>
        <td>Manufacturer:</td>
        <td><frm:input path="pmanfac"/></td>
    </tr>
    
    <tr>
        <td>Product Price:</td>
        <td><frm:input path="pprice"/></td>
    </tr>
    
    <tr>
        <td><input type="submit" value="Add"></td>
        <td><input type="reset" value="Cancel"></td>
    </tr>

</table>

</frm:form>