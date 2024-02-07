<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FYP4U | LOGIN</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
	<link rel="stylesheet" href="css/test.css">
</head>
<body>
<%--<div class="container">--%>
	<header class="header-area row">
		<h1>FYP4U</h1>
	</header>
<body>
<div class="container">
<br><br>
<h3>Login</h3>
<br><br>
<form action="LoginController" method="POST">
 <div class="mb-3">
    <label for="email" class="form-label">Email</label>    
    <input type="email" class="form-control" id="email" name="email" placeholder="Email.." required>   
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>    
    <input type="password" class="form-control" id="password" name="password" placeholder="Password.." required>   
  </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-success" value="Submit"> 
    <input type="reset" class="btn btn-success" value="Reset">  
  </div>
  </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>