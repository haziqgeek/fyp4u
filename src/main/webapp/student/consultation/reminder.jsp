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
<jsp:param name="title" value="FYP4U | Consultation Reminder" />
</jsp:include>
<article class="content col-10">

<div class="container">
<h2>Consultation Reminder</h2>
<form action="ConsultationController" method="POST">

		
	        <label for="stuID">Student ID</label>: <c:out value="${consult.stuID}"/><br>   	
	      	<label for="date">Date</label>: <c:out value="${consult.consultDate}" /><br> 
	      	<label for="time">Time</label>: <c:out value="${consult.consultTime}" /><br> 
	      	<label for="platform">Platform</label>: <c:out value="${consult.platform}" /><br>
	      	<label for="status">Status</label>: <c:out value="${consult.status}" /><br>
	    
      	<br>
        <a class = "link-btn" href="ConsultationController?action=listconsultationforstudent">Back</a>
</form>        
</div>
</article>
</body>
</html>