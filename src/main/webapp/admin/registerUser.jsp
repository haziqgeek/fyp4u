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
<jsp:param name="title" value="FYP4U | Edit Supervisor Profile"/>
</jsp:include>
<!DOCTYPE html>
<article class="content col-10">
<div class="container">
<br><br>
<h3>Register User</h3>
<form action="RegisterUserController" method="POST">
	<div class="mb-3">
    <label for="email" class="form-label">Email</label>    
    <input type="text" class="form-control" id="email" name="email" placeholder="User Email.." required>   
  </div>
   <div class="mb-3">
    <label for="password" class="form-label">User Password</label>    
    <input type="password" class="form-control" id="password" name="password" placeholder="User Password.." required>   
  </div>
    <div class="mb-3">
    <label for="role" class="form-label">Role</label> <br>   
    <input type="radio" id="role" name="role" value="Student" required>Student
    <input type="radio" id="role" name="role" value="Supervisor">Supervisor  
  </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="reset" class="btn btn-primary" value="Reset">  
  </div>
  </form>
</div> 
</article>   		
<jsp:include page="../footer.jsp" />
</body>
</html>