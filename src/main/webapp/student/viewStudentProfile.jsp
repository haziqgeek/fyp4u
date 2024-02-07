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
<jsp:include page="headerStudent.jsp">
<jsp:param name="title" value="FYP4U | Student Profile"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>MY PROFILE</h3>
<br><br>
		<img width="50" height="50" src="StudentImageController?id=<c:out value="${student.stuID}" />">
		<p>PERSONAL INFORMATION</p>
		<label for="stuid">Student ID</label>: <c:out value="${student.stuID}"/><br>
    	<label for="stuname">Name</label>: <c:out value="${student.stuName}"/><br> 	
    	<label for="stusemester">Semester</label>: <c:out value="${student.stuSemester}"/><br>
    	<label for="stucourse">Course Name</label>: <c:out value="${student.stuCourse}"/><br>
    	<label for="stufaculty">Faculty</label>: <c:out value="${student.stuFaculty}"/><br><br>
      	
      	<p>CONNECT</p>
      	<label for="stuphonenum">Phone Number</label>: <c:out value="${student.stuPhoneNum}" /><br>    	
        <%-- <label for="stuEmail">Email</label>: <c:out value="${student.stuEmail}"/><br>  --%> 		
        <label for="stutelegram">Telegram</label>: <c:out value="${student.stuTelegram}" /><br>    	
        <br>
        <a href="EditStudentController?stuid=<c:out value="${student.stuID}" />" class="btn btn-warning">Edit Profile</a>
     
</div>
</article>
</section>
<footer class="row">
	<p>
		<b>FYP4U</b>
	</p>
</footer>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</body>
</html>