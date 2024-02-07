<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerStudent.jsp">
<jsp:param name="title" value="FYP4U | Consultation Status" />
</jsp:include>
<article class="content col-10">

<div class="container">
<h2>Consultation Status</h2>
  <form action="ConsultationController" method="POST">
		<table id="list" class="table table-striped" style="width:100%">
  	<tr>
    <th>Consult ID</th>
    <th>Consultation Date</th>
    <th>Status</th>
    <th colspan="1">Actions</th>
  	</tr>
 	<c:forEach items="${consultation}" var="consult" >
 	<c:if test="${consult.stuID == student.stuID }">
  	<tr>
    <td><c:out value="${consult.consultID}" /></td>
    <td><c:out value="${consult.consultDate}"/></td>
    <td><c:out value="${consult.status}"/></td>   
    <td><a class = "link-btn" href="ConsultationController?action=viewReminder&consultID=<c:out value="${consult.consultID}" />" class="btn btn-primary">Details</a></td>     
    </tr>
    </c:if>
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