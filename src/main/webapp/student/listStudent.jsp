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
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	
	<title>FYP4U | List Student</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" href="StudentDashboardController">Dashboard</a>
  		<a class="navbar-brand" href="listStudent.jsp">Student List</a>
  		<a class="navbar-brand" href="ViewStudentProfileController">My Profile</a> 
  		<a class="navbar-brand" href="ListSupervisorController">Supervisor</a>  		
    </div>
  </nav>
</div>

<div class="container">
<br><br>
<h3>List of Students</h3>
<br><br>
<a href="AddStudentController" class="btn btn-success" style="float:right">ADD STUDENT</a><br><br>
<table class="table table-striped" style="width:100%">
  <tr>
    <th>Student Id</th>
    <th>Image</th>
    <th>Name</th>
    <th>Phone Number</th>
    <th>Email</th>
    <th>Program</th>  
    <th>Faculty</th>   
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${students}" var="student" varStatus="students">
  <tr>
    <td><c:out value="${student.stuID}" /></td>
    <td><img width="50" height="50" src="StudentImageController?id=<c:out value="${student.stuID}" />"></td>
    <td><c:out value="${student.stuName}" /></td>
    <td><c:out value="${student.stuPhoneNum}" /></td>
    <td><c:out value="${student.stuEmail}" /></td>
    <td><c:out value="${student.stuCourse}" /></td>       
    <td><c:out value="${student.stuFaculty}" /></td>  
    <td><a href="ViewStudentProfile?StuID=<c:out value="${student.stuID}" />" class="btn btn-warning">View</a></td>
    <%-- <td><a href="ProductController?action=updateProduct&pid=<c:out value="${product.pid}" />" class="btn btn-primary">Update</a></td>
    <td><input type="hidden" id="pid-${products.index}" value="<c:out value="${product.pid}"/>"><button class="btn btn-danger" onclick="confirmation('${products.index}')">Delete</button></td> --%>   
 
  </c:forEach>
</table>
</div>
	<%-- <script>
		function confirmation(index){
			  var pid = $("#pid-" + index).val();
			 
			  console.log(pid);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'ProductController?action=deleteProduct&pid=' + pid;
				  alert("Product successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> --%>
</body>
</html>