<%@page import="jspstudent.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>

<body>
<%Student  student=(Student)request.getAttribute("student"); %>
<form action="edit" method="post">
ID:<input type="number" name="id" value="<%=student.getStudentId() %>" readonly="readonly">
<br>
<br>
Name:<input type="text" name="name" value="<%=student.getStudentName() %>" required="required">
<br>
<br>
Email:<input type="text" name="email" value="<%=student.getStudentEmail() %>" required="required">
<br>
<br>
Password:<input type="password" name="password" value="<%=student.getStudentPassword() %>" required="required">
<br>
<br>
Address:<input type="text" name="address" value="<%=student.getStudentAddress() %>" required="required">
<br>
<br>
PhoneNumaber:<input type="number" name="phone" value="<%=student.getPhone() %>" required="required">
<br>
<br>
<input type="submit" value="Edit">

</form>
</body>
</html>