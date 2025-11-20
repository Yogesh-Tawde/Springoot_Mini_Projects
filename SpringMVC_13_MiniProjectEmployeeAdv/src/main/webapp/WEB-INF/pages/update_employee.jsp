<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Update Employee</h1>

<frm:form modelAttribute="emp">
<table align="center" bgcolor="cyan">

    <!-- Hidden version field -->
    <frm:hidden path="updateCount"/>


<tr>
    <td>Employee Number:</td>
    <td><frm:input path="eid" readonly="true"/></td>
</tr>

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
    <td>Mobile No:</td>
    <td><frm:input path="emobile"/></td>
</tr>

<tr>
    <td><input type="submit" value="Update Employee"></td>
    <td><input type="reset" value="Cancel"></td>
</tr>

</table>
</frm:form>
