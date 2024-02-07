<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerStudent.jsp" >
  <jsp:param name="title" value="FYP4U | My Project" />
</jsp:include>
<%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/FYP4U/index.jsp");
  %>  
<article class="content col-10">

<div class="container">
<c:choose>
<c:when test="${proj.status == 'Pending'}">
<strong>Your proposal is still pending review from the supervisor.</strong>
</c:when>
<c:when test="${proj.status == 'Submitted'}">
<strong>Your project is already submitted to your supervisor.</strong>
</c:when>
<c:otherwise>
	<h2>My Project</h2>
	<p>
		<b>Project Title:</b> ${proj.projTitle}
	</p>
	<p>
		<b>Description:</b> ${proj.projDescription}
	</p>
	<p>
		<b>Proposal Attachment:</b> <a href="AttachmentController?type=proposal&id=${proj.projID}">Download</a>
	</p>
	<h2>Submit Project</h2>
	<div>
	<form action="ProjectController" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="attachment">Upload file needed for submission (PDF, Limited to 16 MB):</label>
		<input type="hidden" name="projID" value="<c:out value="${proj.projID}" />" />
		 <input class="form-control" type="file" name="attachment" id="submission-input" required>
		 </div>
		<button class="btn btn-primary" type="submit">Submit</button>
		<button class="btn btn-secondary" type="reset">Reset</button>
	</form>
	</div>
	</c:otherwise>
	</c:choose>
	</div>
</article>

</section>
<jsp:include page="../../footer.jsp" />