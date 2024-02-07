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
<jsp:include page="../headerStudent.jsp">
<jsp:param name="title" value="FYP4U | Consultation" />
</jsp:include>

<article class="content col-10">

<div class="container">
<h2>Consultation</h2>
		<a class = "link-btn" href="ConsultationController?action=addConsultation">Booking Consultation</a>
		<a class = "link-btn" href="ConsultationController?action=listConsultationForStudent&consultID=<c:out value="${consultID}" />">Consultation Status</a>
</div>
</article>
</div>
</section>
<footer class="row">
	<p>
		<b>FYP4U</b>
	</p>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
</body>
</body>
</html>