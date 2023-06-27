<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>
<form action="signup">

Id:<input type="number" name="id">
<br>
<br>
Name:<input type="text" name="name">
<br>
<br>
Email:<input type="email" name="email">
<br>
<br>
Password:<input type="password" name="password">
<br>
<br>
Phone:<input type="number" name="phone">
<br>
<br>
Address:<input type="text" name="address">
<br>
<br>
<input type="submit" value="SIGNUP">


</form>
</body>
</html>