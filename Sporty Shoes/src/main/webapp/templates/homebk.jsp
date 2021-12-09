<!DOCTYPE html>
<%@page import="com.ecommerce.phase3.models.Shoes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Objects"%>
<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Home</title>
</head>
<body onload="loadImages()">


	<jsp:include page="header.jsp" />
	<h1>Home</h1>


	<div id="listShoes"></div>
	
	<jsp:include page="footer.jsp" />

	<script src="./script/jquery.min.js"></script>
	<script src="./script/home.js"></script>

</body>
</html>