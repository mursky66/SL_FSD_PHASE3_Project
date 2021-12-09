<!DOCTYPE html>
<%@page import="com.ecommerce.phase3.models.Shoes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Objects"%>
<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-AddToCart</title>
</head>
<body onload="loadImages()">


	<jsp:include page="header.jsp" />
	<h1>Add To Cart</h1>

	<%
	if (Objects.nonNull(request.getAttribute(SportyShoesConstant.DATA))) {
		Shoes shoes = (Shoes) request.getAttribute(SportyShoesConstant.DATA);
	%>
	<form action="./checkout" method="post">
	Shoes Name: <%=shoes.getShoesName() %>  <br><br>
	
	Shoes Price: <%=shoes.getShoesPrice() %>  <br><br>
		
	<input type="submit" value="checkout">
	</form>
	<%	
	}
	%>

	<jsp:include page="footer.jsp" />

	<script src="./script/jquery.min.js"></script>
	<script src="./script/home.js"></script>

</body>
</html>