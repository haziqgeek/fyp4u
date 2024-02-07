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
<jsp:include page="headerAdmin.jsp">
<jsp:param name="title" value="FYP4U | Admin Dashboard"/>
</jsp:include>

<article class="content col-10">
<div class="container" >

	<div class="container">
  	<h2><b>DASHBOARD</b></h2><br><br>
  	
		<br>
		<div class="container" >

		<h3>Admin Profile</h3>
		<br>
		
  		<label for="AdminId">Admin ID</label>: <c:out value="${admin.adminID}"/><br>
    	<label for="AdminUsername">Admin Username</label>: <c:out value="${admin.adminUsername}"/><br>    	
      	<label for="AddPhoneNum">Phone Number</label>: <c:out value="${admin.adminPhonenumber}" /><br><br> <br>   
    </div> 
    </div> 	
</article>

</body>
</html>