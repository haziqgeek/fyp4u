<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerSupervisor.jsp">
<jsp:param name="title" value="FYP4U | Consultation Request" />
</jsp:include>
<article class="content col-10">

<div class="container">
<h2>Consultation Request</h2>
  <form action="ConsultationController" method="POST">
		<table id="list" class="table table-striped" style="width:100%">
  <tr>
    <th>Student ID</th>
    <th>Student Name</th>
    <th>Consultation Date</th>
    <th>Status</th>
    <th colspan="2">Actions</th>
  </tr>
 <c:forEach items="${consultation}" var="c">
  	<tr>
    <td><c:out value="${c.student.stuID}" /></td>
    <td><c:out value="${c.student.stuName}" /></td>
    <td><c:out value="${c.consultDate}"/></td>
    <td><c:out value="${c.status}"/></td>   
    <td><a class = "link-btn" href="ConsultationController?action=updateConsultation&consultID=<c:out value="${c.consultID}" />" class="btn btn-primary">Request</a></td>
    <td><a class = "link-btn" href="ConsultationController?action=viewConsultationforSupervisor&consultID=<c:out value="${c.consultID}" />" class="btn btn-primary">Details</a></td>     
     </tr>	   
    </c:forEach>       
</table>
</form>        
</div>
<script>
$(document).ready(function() {
    $('#list').DataTable();
} );
</script>
<script src="js/bootstrap.min.js"></script>
</article>
<jsp:include page="../../footer.jsp"/>
</body>
</html>