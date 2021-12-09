<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes-Dashboard</title>
</head>
<body>

	<jsp:include page="header.jsp" />


	<table>
		<tr>
			<td width="20%">
				<p>
					<a href="./addShoes">Add
						Shoes</a> 
						<a href="./viewShoes">View Shoes</a>
				</p>
			</td>
			<td><h1>Admin Dashboard</h1></td>
		</tr>
	</table>


	<jsp:include page="footer.jsp" />


</body>
</html>