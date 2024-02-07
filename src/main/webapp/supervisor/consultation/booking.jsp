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
<jsp:include page="../headerSupervisor.jsp">
<jsp:param name="title" value="FYP4U | Booking Request" />
</jsp:include>
<article class="content col-10">

<div class="container">
<h2>Booking Request</h2>
  <form action="ConsultationController" method="POST">
  <div class="mb-3">
    <label for="consultID" class="form-label"><b>Consult ID</b></label>    
    <input type="text" class="form-control" id="consultID" name="consultID" value="<c:out value="${consult.consultID}"/>" readonly>  
  </div>
  <div class="mb-3">
    <label for="stuID" class="form-label"><b>Student ID</b></label>    
    <input type="text" class="form-control" id="stuID" name="stuID" value="<c:out value="${consult.stuID}"/>" readonly>  
  </div>
  <div class="mb-3">
    <label for="platform" class="form-label"><b>Consultation Platform</b> </label>    
    <input type="text" class="form-control" id="platform" name="platform" value="<c:out value="${consult.platform}"/>" required>   
  </div>
  <div class="mb-3">
    <label for="description" class="form-label"><b>Description</b> </label>    
    <input type="text" class="form-control" id="description" name="description" value="<c:out value="${consult.description}"/> "readonly>    
  </div>
  <div class="mb-3">
    <label for="date" class="form-label"><b> Consultation Date</b></label>    
    <input type="text" class="form-control" id="date" name="consultDate" value="<c:out value="${consult.consultDate}"/>" readonly>   
  </div>
  <div class="mb-3">
    <label for="time" class="form-label"><b> Consultation Time</b></label>    
    <input type="text" class="form-control" id="time" name="consultTime" value="<c:out value="${consult.consultTime}"/>" readonly>   
  </div>  
  <div class="mb-3">
    <label for="status" class="form-label"><b> Status</b></label>    
    <input type="text" class="form-control" id="status" name="status" value=<c:out value="${consult.status}"/> required>  
  </div>  
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="hidden" name="supID" value="<c:out value="${consult.supID}"/>" />       
  </div> 
</form>
</div>
	</article>
	<jsp:include page="../../footer.jsp"/>
</body>
</html>