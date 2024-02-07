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
<jsp:param name="title" value="FYP4U | Project Evaluation" />
</jsp:include>
<article >

<div class="container">
<h2><b>Project Evaluation</b></h2><br>

  <form action="ProjectEvaluationController" method="POST"> 
    <input type="hidden" id="stuID" name="stuID" value="<c:out value="${proj.stuID}"/>">   
    <input type="hidden" id="supID" name="supID" value="<c:out value="${proj.supID}"/>">
    <input type="hidden" id="projID" name="projID" value="<c:out value="${proj.projID}"/>">
  <div class="mb-3">
    <label for="projTitle" class="form-label"><b>Project Title</b></label>    
    <input type="text" class="form-control" id="projTitle" name="projTitle" value="<c:out value="${proj.projTitle}"/>" readonly>   
  </div>
  <div class="mb-3">
    <label for="projDescription" class="form-label"><b>Project Description</b> </label>    
    <textarea class="form-control" id="description" name="projDescription" readonly><c:out value="${proj.projDescription}"/></textarea>    
  </div>
  <div class="mb-3">
    <label for="attachment" class="form-label"><b>Proposal Attachment: </b> <a href="AttachmentController?type=proposal&id=<c:out value="${proj.projID}" />">Download</a></label>
  </div>
  <div class="mb-3">
    <label for="attachment" class="form-label"><b>Project Attachment: </b> <a href="AttachmentController?type=project&id=<c:out value="${proj.projID}" />">Download</a></label>
  </div>
  <div class="mb-3">
    <label for="status" class="form-label"><b>Status</b></label>    
    <input type="text" class="form-control" id="status" name="status" value="<c:out value="${proj.status}"/>" readonly>   
  </div>  
  <div class="mb-3">
    <label for="submissionDate" class="form-label"><b>Submission Date</b> </label>    
    <input type="text" class="form-control" id="submissionDate" name="submissionDate" value="<c:out value="${proj.submissionDate}"/>" readonly>   
  </div>
  <div class="mb-3">
    <label for="deadline" class="form-label"><b>Deadline</b> </label>    
    <input type="text" class="form-control" id="deadline" name="deadline" value="<c:out value="${proj.deadline}"/>" readonly>   
  </div>
  <div class="mb-3">
    <label for="score" class="form-label"><b>Score</b> </label>    
    <input type="text" class="form-control" id="score" name="score" required>   
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