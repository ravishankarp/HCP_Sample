<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:useBean id="readingList" scope="session" class="java.util.ArrayList" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HCP Book: Chapter 03</title>
<link href="css/style.css" rel="stylesheet">
</head>



<body>
<h1> My HCP Reading List </h1>
<table class="readingList">
	<tr> 
		<th> Book Title </th>
	</tr>
	<c:forEach var="book" items="${readingList}">
		<tr><td><c:out value="${book}" /> </td></tr>
	</c:forEach>
	
</table>

<section> 
	<form method="post" action="ReadingListServlet"> <div>
	<label for="inpBook">
	Book:	<input id="inpBook" name="book" />
	</label>&nbsp;
	<button type="submit">Add</button>
	
	</div></form>
	</section>

</body>
</html>