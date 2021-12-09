<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Customer Signup</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1>Customer Signup</h1>


	<%
	if (Objects.nonNull(request.getAttribute(SportyShoesConstant.MESSAGE))) {
	%>
	<%=request.getAttribute(SportyShoesConstant.MESSAGE).toString()%>
	<%
	

	}
	%>

	<form action="./customer-signup" method="POST">

		Name <input type="text" name="name"> <br> Email <input
			type="text" name="email"> <br> Gender <select
			name="gender">
			<option value="male">Male</option>
			<option value="female">Female</option>
		</select> <br> Password <input type="password" name="password"> <br>
		Mobile <input type="text" name="mobile"> <br> <input
			type="submit" name="btnSignup" value="Signup">


	</form>

	<jsp:include page="footer.jsp" />


</body>
</html>