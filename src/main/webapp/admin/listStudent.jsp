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
<jsp:param name="title" value="FYP4U | Student List"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>STUDENT LIST</h3>
<br><br>
<a href="RegisterUserController" class="btn btn-success" style="float:right">ADD USER</a><br><br>
<table class="table table-striped" style="width:100%" >
  <tr>
  	<th>Student ID</th>
    <th>Student Name</th> 
    <th>Semester</th> 
    <th>Program</th>  
    <th>Faculty</th>

    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${students}" var="student" varStatus="students">
  <tr>
    <td><c:out value="${student.stuID}" /></td>
    <td><c:out value="${student.stuName}" /></td>
    <td><c:out value="${student.stuSemester}" /></td> 
    <td><c:out value="${student.stuCourse}" /></td>  
    <td><c:out value="${student.stuFaculty}" /></td>
 
       
    <td><a href="ViewStudentProfileController?stuid=<c:out value="${student.stuID}" />" class="btn btn-warning">View</a></td>
    <td><a href="adminEditStudentProfileController?stuid=<c:out value="${student.stuID}" />" class="btn btn-primary">Update</a></td>
    <td><input type="hidden" id="stuid-${students.index}" value="<c:out value="${student.stuID}"/>"><button class="btn btn-danger" onclick="confirmation('${students.index}')">Delete</button></td>    
       
  </c:forEach>
</table>
</div>
	<script>
		function confirmation(index){
			  var stuid = $("#stuid-" + index).val();
			 
			  console.log(stuid);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'DeleteStudentController?stuid=' +stuid;
				  alert("Student successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>