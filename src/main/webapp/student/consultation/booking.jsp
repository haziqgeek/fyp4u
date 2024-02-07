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
<jsp:param name="title" value="FYP4U | New Booking" />
</jsp:include>
<article >

<div class="container">
<h2><b>New Booking</b></h2><br>

  <form action="ConsultationController" method="POST"> 
    <input type="hidden" id="stuID" name="stuID" value="<c:out value="${student.stuID}"/>">   
    <input type="hidden" id="supID" name="supID" value="<c:out value="${project.supID}"/>">
  <div class="mb-3">
    <label for="platform" class="form-label"><b>Consultation Platform</b> </label>    
    <input type="text" class="form-control" id="platform" name="platform" placeholder="Google meet / supervisor office" required>   
  </div>
  <div class="mb-3">
    <label for="description" class="form-label"><b>Description</b> </label>    
    <input type="text" class="form-control" id="description" name="description" placeholder="Description.." required>    
  </div>
  <div class="mb-3">
    <label for="date" class="form-label"><b> Consultation Date</b></label>    
    <input type="date" class="form-control" id="consultDate" name="consultDate" required>   
  </div>
  <div class="mb-3">
    <label for="time" class="form-label"><b> Consultation Time</b></label>    
    <input type="time" class="form-control" id="consultTime" name="consultTime" required>   
  </div>  
  <div class="mb-3">
    <label for="status" class="form-label"><b>Status</b> </label>    
    <input type="text" class="form-control" id="status" name="status" placeholder="New Booking" required>   
  </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary"value="Submit">
    <input type="reset" class="btn btn-secondary" value="Reset">  
  </div>
  </form>
</div>
</article>
</body>
</html>