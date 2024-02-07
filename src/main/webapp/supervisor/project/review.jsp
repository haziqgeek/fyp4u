<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerSupervisor.jsp" >
  <jsp:param name="title" value="FYP4U | Supervisor Project Acceptance" />
</jsp:include>
        <article class="content col-10">

            <h1>Supervisor Project Acceptance</h1>
    <table class="table">
        <tr>
            <th>Name</th>
            <th>Course</th>
            <th>Project Title</th>
            <th>Proposal Attachment</th>
            <th>Accept/Reject</th>
        </tr>
        <c:forEach items="${projs}" var="proj">
        <c:if test="${proj.status=='Pending'}">
        <tr>
            <td><c:out value="${proj.student.stuName}" /></td>
            <td><c:out value="${proj.student.stuCourse}" /></td>
            <td><c:out value="${proj.projTitle}" /></td>
            <td><a href="AttachmentController?id=<c:out value="${proj.student.stuID}" />">Download</a></td>
            <td><a class="btn btn-success" href="ProjectController?action=acceptProject&id=<c:out value="${proj.projID}" />">Accept</a><a class="btn btn-danger" href="ProjectController?action=deleteProject&id=<c:out value="${proj.projID}" />">Reject</a></td>
        </tr>
        </c:if>
        </c:forEach>
    </table>
        </article>

    </section>

  <jsp:include page="../../footer.jsp" />