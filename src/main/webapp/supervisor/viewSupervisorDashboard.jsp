<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/FYP4U/index.jsp");
  %>  
<jsp:include page="headerSupervisor.jsp">
	<jsp:param name="title" value="FYP4U | Supervisor Dashboard" />
</jsp:include>
<article class="content col-10">

	<div class="container">

		<h3>DASHBOARD</h3>
		<br>
		<div class="gallery">
			<a href="ProjectController?action=list">
				<img src="images/heh.jpeg" alt="Project in progress" width="600"
				height="400">
			</a>
			<div class="card-single">
				<div>
					<span>Project Details</span>
				</div>
				<div>
					<span class="las la-users"></span>
				</div>
			</div>
		</div>

		<div class="gallery"></div>

		<div class="gallery">
			<a href="ConsultationController?action=listConsultation">
				<img src="images/huhu.jpeg" alt="total project request" width="600"
				height="400">
			</a>
			<div>
				<span> Consultation Request</span>
			</div>
			<div>
				<span class="las la-users"></span>
			</div>
		</div>

		<div class="gallery"></div>

		<div class="gallery">
			<a href="ProjectController?action=listReview">
				<img src="images/hmm.jpeg" alt="consultations assigned" width="600"
				height="400">
			</a>
			<div class="card-single">
				<div>
					<span>Project Review</span>
				</div>
				<div>
					<span class="las la-users"></span>
				</div>
			</div>
		</div>


		</body>
		</html>