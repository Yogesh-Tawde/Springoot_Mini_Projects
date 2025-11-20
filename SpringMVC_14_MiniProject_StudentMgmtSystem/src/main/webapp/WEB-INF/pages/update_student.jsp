<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Update Student</h1>

<frm:form modelAttribute="stud">
<table align="center" bgcolor="cyan">

    <!-- Hidden version field -->
    <frm:hidden path="updateCount"/>
    <tr>
    		<td>Student Number:</td>
    		<td><frm:input path="sid" readOnly="true"/></td>
    </tr>
    
     <tr>
    		<td>Student Name:</td>
    		<td><frm:input path="sname"/></td>
    </tr>
    
     <tr>
    		<td>Student Grade:</td>
    		<td><frm:input path="sgrade"/></td>
    </tr>
    
     <tr>
    		<td>Student Address:</td>
    		<td><frm:input path="sadd"/></td>
    </tr>
     <tr>
    		<td>Student Contact:</td>
    		<td><frm:input path="scontact"/></td>
    </tr>
    
    <tr>
    		<td><input type="submit" value="Update Student"></td>
    		<td><input type="reset" value="Cancel"></td>
	</tr>
    
    </table>
</frm:form>    