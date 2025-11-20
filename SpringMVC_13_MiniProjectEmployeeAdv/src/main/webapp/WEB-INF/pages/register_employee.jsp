<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Register Employee</h1>

<frm:form modelAttribute="emp">

<table align="center" bgcolor="cyan">

    <tr>
        <td>Employee Name:</td>
        <td><frm:input path="ename"/></td>
    </tr>
    
    <tr>
        <td>Employee Designation:</td>
        <td><frm:input path="edeg"/></td>
    </tr>
    
    <tr>
        <td>Employee Address:</td>
        <td><frm:input path="eadd"/></td>
    </tr>
    
    <tr>
        <td>Employee Salary:</td>
        <td><frm:input path="esal"/></td>
    </tr>
    
    <tr>
        <td>Employee Mobile:</td>
        <td><frm:input path="emobile"/></td>
    </tr>

    <tr>
        <td><input type="submit" value="Register"></td>
        <td><input type="reset" value="Cancel"></td>
    </tr>

</table>

</frm:form>
