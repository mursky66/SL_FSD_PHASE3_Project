<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Add Shoess</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<h1>Add Shoes</h1>


	<%
	if (Objects.nonNull(request.getAttribute(SportyShoesConstant.MESSAGE))) {
	%>
	<%=request.getAttribute(SportyShoesConstant.MESSAGE).toString()%>
	<%
	}
	%>

	<form action="./addShoes" method="POST" enctype="multipart/form-data">

		Shoes Category  <select name="shoesCategory">
					  	<option value="sports">Sports</option>
						<option value="casual">Casual</option>
						<option value="traditional">Traditional</option>
						</select> <br> 
		
		Shoes Name <input type="text" name="shoesName"> <br>

		Shoes Price <input type="text" name="shoesPrice"> <br>

		Shoes Image <input type="file" name="shoesImge"> <br> <input type="submit"
			name="btnAddProduct" value="Add Shoes">


	</form>

	<jsp:include page="footer.jsp" />


</body>
</html>