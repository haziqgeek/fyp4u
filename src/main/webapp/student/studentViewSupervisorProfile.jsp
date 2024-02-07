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
<jsp:param name="title" value="FYP4U | Supervisor Profile"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>MY PROFILE</h3>
<br><br>
		<img width="50" height="50" src="SupervisorImageController?id=<c:out value="${supervisor.supID}" />">
		<p>PERSONAL INFORMATION</p>
		<label for="supid">Supervisor ID</label>: <c:out value="${supervisor.supID}"/><br>
    	<label for="supname">Name</label>: <c:out value="${supervisor.supName}"/><br> 	
    	<label for="supfaculty">Faculty</label>: <c:out value="${supervisor.supFaculty}"/><br><br>
      	
      	<p>CONNECT</p>
      	<label for="supphonenum">Phone Number</label>: <c:out value="${supervisor.supPhoneNum}" /><br>    	
        <%-- <label for="stuEmail">Email</label>: <c:out value="${student.stuEmail}"/><br>  --%> 		
        <label for="suptelegram">Telegram</label>: <c:out value="${supervisor.supTelegram}" /><br>    	
        <br>
        <a href="StudentListSupervisorController" class="btn btn-success">Supervisor List</a>
     
</div>
</article>
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>