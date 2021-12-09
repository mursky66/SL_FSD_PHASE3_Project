<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-AdminLogin</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1>Admin Login</h1>
	
	
	<% 
	
	if(Objects.nonNull(request.getAttribute(SportyShoesConstant.MESSAGE))){
		%>
		<%=request.getAttribute(SportyShoesConstant.MESSAGE).toString() %>
		<% 
	}
	
	%>

<form action="./adminLogin" method="POST">

Email
<input type="text" name="email" > <br>

Password
<input type="password" name="password" > <br>

<input type="submit" name="btnLogin" value="Admin Login">


</form>

	<jsp:include page="footer.jsp" />


</body>
</html>