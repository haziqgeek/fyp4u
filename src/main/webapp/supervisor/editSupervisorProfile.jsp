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
<jsp:include page="headerSupervisor.jsp">
<jsp:param name="title" value="FYP4U | Supervisor Profile"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>Edit Profile</h3>
<br><br>
  <form action="EditSupervisorController" method="POST">
  <div class="mb-3">
    <label for="supid" class="form-label">Supervisor Id</label>
        <input type="text" class="form-control" id="supid" name="supID" value="<c:out value="${supervisor.supID}"/>" required> 
  </div> 
    <div class="mb-3">
    <label for="supname" class="form-label">Name</label>
    <input type="text" class="form-control" id="supname" name="supName" value="<c:out value="${supervisor.supName}"/>" required>    
  </div>
    <div class="mb-3">
    <label for="supfaculty">Faculty</label>
    <select class="form-control" id="supfaculty" name="supFaculty" value="<c:out value="${supervisor.supFaculty}"/>" required>   
      <option value="FSKM">FSKM</option>
	  <option value="FPA">FPA</option>
    </select>
    </div>
  <div class="mb-3">
    <label for="supphonenum" class="form-label">Phone Number</label>
    <input type="text" class="form-control" id="supphonenum" name="supPhoneNum" value="<c:out value="${supervisor.supPhoneNum}"/>" required>   
  </div>
  <div class="mb-3">
    <label for="suptelegram" class="form-label">Telegram</label>
    <input type="text" class="form-control" id="suptelegram" name="supTelegram" value="<c:out value="${supervisor.supTelegram}"/>" required>   
  </div>
   <div class="mb-3">    
        <input type="hidden" class="form-control" name="userID" value="<c:out value="${supervisor.userID}"/>"/> 
    </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit">
    <input type="reset" class="btn btn-secondary" value="Reset">
  </div>     
  </form>
</div>

</article>
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>