<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Change Password</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1>Change Password</h1>

<% 
	
	if(Objects.nonNull(request.getAttribute(SportyShoesConstant.MESSAGE))){
		%>
		<%=request.getAttribute(SportyShoesConstant.MESSAGE).toString() %>
		<% 
	}
	
	%>

	<form action="./changePassword" method="POST">

		Email <input type="text" name="email"> <br> 
		
		Old Password
		<input type="password" name="oldpassword"> <br> 

New Password
		<input type=""password"" name="newpassword"> <br> 
		

		<input
			type="submit" name="btnChngPwd" value="Change Password">


	</form>

	<jsp:include page="footer.jsp" />


</body>
</html>