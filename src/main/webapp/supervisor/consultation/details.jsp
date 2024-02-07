<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerSupervisor.jsp">
<jsp:param name="title" value="FYP4U | Consultation Details" />
</jsp:include>
<article class="content col-10">

<div class="container">
<h2>Consultation Details</h2>
<form action="ConsultationController" method="POST">
		<label for="stuID">Student ID</label>: <c:out value="${consultation.stuID}"/><br>   	
      	<label for="consultDate">Date</label>: <c:out value="${consultation.consultDate}" /><br> 
      	<label for="consultTime">Time</label>: <c:out value="${consultation.consultTime}" /><br> 
      	<label for="platform">Platform</label>: <c:out value="${consultation.platform}" /><br><br>      
        <a class = "link-btn" href="ConsultationController?action=listConsultation">Back</a>
</form>        
</div>
</article>
</body>
</html>