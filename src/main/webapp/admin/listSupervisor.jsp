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
<jsp:param name="title" value="FYP4U | Supervisor List"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>SUPERVISOR LIST</h3>
<br><br>
<a href="RegisterUserController" class="btn btn-success" style="float:right">ADD USER</a><br><br>
<table class="table table-striped" style="width:100%" >
  <tr>
  	<th>Supervisor ID</th>
    <th>Supervisor Name</th>
    <th>Phone Number</th>    
    <th>Faculty</th> 

    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${supervisors}" var="supervisor" varStatus="supervisors">
  <tr>
    <td><c:out value="${supervisor.supID}" /></td>
    <td><c:out value="${supervisor.supName}" /></td>
    <td><c:out value="${supervisor.supPhoneNum}" /></td>
    <td><c:out value="${supervisor.supFaculty}" /></td> 
 
       
    <td><a href="ViewSupervisorProfileController?supId=<c:out value="${supervisor.supID}" />" class="btn btn-warning">View</a></td>
    <td><a href="adminEditSupervisorController?supId=<c:out value="${supervisor.supID}" />" class="btn btn-primary">Update</a></td>
    <td><input type="hidden" id="supId-${supervisors.index}" value="<c:out value="${supervisor.supID}"/>"><button class="btn btn-danger" onclick="confirmation('${supervisors.index}')">Delete</button></td>    
       
  </c:forEach>
</table>
</div>
	<script>
		function confirmation(index){
			  var supId = $("#supId-" + index).val();
			 
			  console.log(supId);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'SupervisorController?action=deleteSupervisor&supId=' +supId;
				  alert("Student successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>