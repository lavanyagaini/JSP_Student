<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="jspstudent.dto.Student" %> 
<!-- Assuming the Student class is in the com.example package -->

<%List<Student> students=(List) request.getAttribute("list");%>
<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>Fees</th>
<th>Phone</th>
<th>Delete</th>
<th>Update</th>
<% if (students != null) { %>
    <% for(Student student:students){ %>
    <tr>
        <td><%=student.getStudentId() %></td>
        <td><%=student.getStudentName() %></td>
        <td><%=student.getStudentEmail() %></td>
        <td><%=student.getStudentPassword() %></td>
        <td><%=student.getStudentAddress() %></td>
        <td><%=student.getFees() %></td>
        <td><%=student.getPhone() %></td>
        <td><a href="delete?id=<%=student.getStudentId()  %>">Delete</a></td>
        <td><a href="update?id=<%= student.getStudentId() %>">Update</a></td>
    </tr>
    <% } %>
<% } %>
</table>
</body>
</html>