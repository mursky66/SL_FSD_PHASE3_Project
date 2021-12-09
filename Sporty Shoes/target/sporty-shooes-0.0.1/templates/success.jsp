<!DOCTYPE html>
<%@page import="com.ecommerce.phase3.constants.SportyShoesConstant"%>
<%@page import="java.util.Objects"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Home</title>
</head>
<body>


     <jsp:include page="header.jsp" />
     
     <% 
	
	if(Objects.nonNull(request.getAttribute(SportyShoesConstant.MESSAGE))){
		%>
		<h1> <%=request.getAttribute(SportyShoesConstant.MESSAGE).toString() %> </h1>
		<% 
	}
	
	%>
     

     <jsp:include page="footer.jsp" /> 
</body>
</html>