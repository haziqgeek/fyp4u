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
<jsp:param name="title" value="FYP4U | Edit Student Profile"/>
</jsp:include>
<article class="content col-10">

<div class="container">
<br><br>
<h3>Edit Profile</h3>
<br><br>
  <form action="adminEditStudentProfileController" method="POST" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="stuid" class="form-label">Student Id</label>
        <input type="text" class="form-control" id="stuid" name="stuID" value="<c:out value="${student.stuID}"/>"/> 
  </div> 
    <div class="mb-3">
    <label for="stuname" class="form-label">Name</label>
    <input type="text" class="form-control" id="stuname" name="stuName" value="<c:out value="${student.stuName}"/>" required>    
  </div>
  <div class="mb-3">
    <label for="stuImage" class="form-label">Profile Picture:</label>
    <img style="margin-left: 0;" width="100" height="100" src="StudentImageController?id=<c:out value="${student.stuID}"/>" />
    <input type="file" class="form-control" id="stuImage" name="stuImage">    
  </div>
      <div class="mb-3">
    <label for="stusemester">Semester</label>
    <select class="form-control" id="stusemester" name="stuSemester" required>   
      <option value="5">5</option>
	  <option value="6">6</option>
    </select>
    </div> 
  <div class="mb-3">
    <label for="stucourse">Program</label>
    <select class="form-control" id="stucourse" name="stuCourse" required>   
      <option value="CS230 - Bachelor of Computer Science(Hons.)">CS230 - Bachelor of Computer Science(Hons.)</option>
       <option value="CS251 - Bachelor of Computer Science(Hons.)NETCENTRIC COMPUTING">CS230 - Bachelor of Computer Science(Hons.)NETCENTRIC COMPUTING</option>
<option value="CS253 - Bachelor of Computer Science(Hons.)MULTIMEDIA COMPUTING ">CS230 - Bachelor of Computer Science(Hons.)MULTIMEDIA COMPUTING</option>
	  <option value="CS255 - Bachelor of Computer Science(Hons.)COMPUTER NETWORKS">CS230 - Bachelor of Computer Science(Hons.)COMPUTER NETWORKS</option>
	 <option value="CS266 - Bachelor of Information Technology (Hons.) Information Systems Engineering">CS266 - Bachelor of Information Technology (Hons.) Information Systems Engineering</option>
   
<option value="AT232 - B.Sc(Hons) in Agrotechnology(Horticlture Technology)"> B.Sc(Hons) in Agrotechnology(Horticlture Technology)</option>
    <option value="AT228 - B.Sc of Smart Crop Production Technology">B.Sc of Smart Crop Production Technology</option>
    </select>
    </div>  
   <div class="mb-3">
    <label for="stufaculty">Faculty</label>
    <select class="form-control" id="stufaculty" name="stuFaculty" required>   
      <option value="FSKM">FSKM</option>
	  <option value="FPA">FPA</option>
    </select>
    </div>
    <div class="mb-3">
    <label for="stuPhoneNum" class="form-label">Phone Number</label>
    <input type="text" class="form-control" id="stuPhoneNum" name="stuPhoneNum" value="<c:out value="${student.stuPhoneNum}"/>" required>
    </div> 
    <div class="mb-3">
    <label for="stuTelegram" class="form-label">Telegram</label>
    <input type="text" class="form-control" id="stuTelegram" name="stuTelegram" value="<c:out value="${student.stuTelegram}"/>">
    </div> 
    <div class="mb-3">    
        <input type="hidden" class="form-control" name="userID" value="<c:out value="${student.userID}"/>"/> 
    </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit">
    <input type="reset" class="btn btn-primary" value="Reset">
  </div>     
  </form>
</div>

</article>
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>