<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerSupervisor.jsp" >
  <jsp:param name="title" value="My Project" />
</jsp:include>
        <article class="content col-10">

            <h1>Project Details</h1>
            <br><br>
            <h2>Ongoing Projects</h2>
    <table class="table">
        <tr>
            <th>Name</th>
            <th>Course</th>
            <th>Project Title</th>
            <th>Proposal Attachment</th>
            <th>Status</th>
            <th>Deadline</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${projs}" var="proj">
        <tr>
        <c:if test="${proj.status=='In Progress'}">
            <td><c:out value="${proj.student.stuName}" /></td>
            <td><c:out value="${proj.student.stuCourse}" /></td>
            <td><c:out value="${proj.projTitle}" /></td>
            <td><a href="AttachmentController?type=proposal&id=<c:out value="${proj.student.stuID}" />">Download</a></td>
            <td><c:out value="${proj.status}" /></td>
            <td><c:out value="${proj.deadline}" /></td>
            <td><a href="SupervisorViewStudentProfileController?id=<c:out value="${proj.student.stuID}" />">View Profile</a></td>
            <td><a href="ProjectController?action=deadline&id=<c:out value="${proj.projID}" />">Set A Deadline</a></td>
        </tr>
        </c:if>
        </c:forEach>
    </table>
    <br>
    <h2>Submitted Projects</h2>
    <table class="table">
        <tr>
            <th>Name</th>
            <th>Course</th>
            <th>Project Title</th>
            <th>Proposal Attachment</th>
            <th>Project Attachment</th>
            <th>Submission Date</th>
            <th>Deadline</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${projs}" var="proj">
        <tr>
        <c:if test="${proj.status=='Submitted'}">
            <td><c:out value="${proj.student.stuName}" /></td>
            <td><c:out value="${proj.student.stuCourse}" /></td>
            <td><c:out value="${proj.projTitle}" /></td>
            <td><a href="AttachmentController?type=proposal&id=<c:out value="${proj.projID}" />">Download</a></td>
            <td><a href="AttachmentController?type=project&id=<c:out value="${proj.projID}" />">Download</a></td>
            <td><c:out value="${proj.submissionDate}" /></td>
            <td><c:out value="${proj.deadline}" /></td>
            <td><a href="ProjectController?action=evaluate&id=<c:out value="${proj.projID}" />">Evaluate</a></td>
            <td><a href="SupervisorViewStudentProfileController?id=<c:out value="${proj.student.stuID}" />">View Profile</a></td>
        </tr>
        </c:if>
        </c:forEach>
    </table>
        </article>

    </section>

<jsp:include page="../../footer.jsp" />