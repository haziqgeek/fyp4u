<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../headerStudent.jsp" >
  <jsp:param name="title" value="Propose a Project" />
</jsp:include>
<%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/FYP4U/index.jsp");
  %>  


        <article class="content col-10">
<div class="container">
            <h1>Propose a Project</h1>
    <form action="ProposalController" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="stuID" value="<c:out value="${student.stuID}" />">
        <div class="form-group">
            <label for="title">Project Title</label>
            <input type="text" name="projTitle" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="description">Project Description</label><br>
            <textarea class="form-control" name="projDescription" id="description" cols="30" rows="10" required></textarea>
        </div>
        <div class="form-group">
            <label for="attachment">Proposal Attachment (PDF, Limited to 16 MB)</label>
            <input class="form-control" type="file" name="attachment" accept=".pdf">
        </div>
        <div class="form-group">
            <label for="supervisor">Supervisor</label>
            <select class="form-control" name="supID" required>
            <c:forEach items="${supervisors}" var="sup">
                <option value="<c:out value="${sup.supID}" />"><c:out value="${sup.supName}" /></option>
                </c:forEach>
                
            </select><br>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form>
        </article>

    </section>

<jsp:include page="../../footer.jsp" />