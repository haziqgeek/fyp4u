<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title><%=request.getParameter("title")%></title>
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
	<section class="row">
		<nav class="col-2">
			<div class="user-wrapper">
				<img src="StudentImageController?id=<c:out value="${student.stuID}" />" width="80px" height="80px">
					<p class="role font-weight-bold text-uppercase text-center"><c:out value="${user.role}" /></p>
					<p class="name font-weight-bold text-uppercase text-center"><c:out value="${student.stuName}" /></p>
					<p class="id font-weight-bold text-center"><c:out value="${student.stuID}" /></p>
			</div>
			<ul>
				<li><a href="ViewStudentProfileController?userid=<c:out value="${student.userID}" />">MY PROFILE</a></li>
				<li><a href="ViewStudentDashboardController?userid=<c:out value="${student.userID}"/>">DASHBOARD</a></li>
				<li><a href="StudentListSupervisorController">SUPERVISOR</a></li>
				<li><a href="ProjectController?action=viewStudentProject&id=<c:out value="${student.stuID}"/>">PROJECT</a></li>
				<li><a href="ConsultationController?action=index">CONSULTATION</a></li>
				<li><a href="LogoutController">LOGOUT</a></li>
			</ul>
		</nav>