<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="headerStudent.jsp">
<jsp:param name="title" value="FYP4U | Edit Student Profile"/>
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
<br><br>
<h3>Edit Profile</h3>
<br><br>
  <form action="EditStudentController" method="POST">
  <div class="mb-3">
    <label for="stuid" class="form-label">Student Id</label>
        <input type="text" class="form-control" id="stuid" name="stuid" value="<c:out value="${student.stuID}"/>" required> 
  </div> 
    <div class="mb-3">
    <label for="stuname" class="form-label">Name</label>
    <input type="text" class="form-control" id="stuname" name="stuname" value="<c:out value="${student.stuName}"/>" required>    
  </div>
  <div class="mb-3">
    <label for="stusemester">Semester</label>
    <select class="form-control" id="stusemester" name="stusemester" value="<c:out value="${student.stuSemester}"/>" required>   
      <option value="5">5</option>
	  <option value="6">6</option>
    </select>
    </div>   
  <div class="mb-3">
    <label for="stucourse">Program</label>
    <select class="form-control" id="stucourse" name="stucourse" value="<c:out value="${student.stuCourse}"/>" required>   
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
    <select class="form-control" id="stufaculty" name="stufaculty" value="<c:out value="${student.stuFaculty}"/>" required>   
      <option value="FSKM">FSKM</option>
	  <option value="FPA">FPA</option>
    </select>
    </div>
  <div class="mb-3">
    <label for="stuphonenum" class="form-label">Phone Number</label>
    <input type="text" class="form-control" id="stuphonenum" name="stuphonenum" value="<c:out value="${student.stuPhoneNum}"/>" required>   
  </div>
  <div class="mb-3">
    <label for="stutelegram" class="form-label">Telegram</label>
    <input type="text" class="form-control" id="stutelegram" name="stutelegram" value="<c:out value="${student.stuTelegram}"/>">   
  </div>
   <div class="mb-3">    
        <input type="hidden" class="form-control" name="userid" value="<c:out value="${student.userID}"/>"/> 
    </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit">
    <input type="reset" class="btn btn-secondary" value="Reset">
  </div>     
  </form>
</div>

</article>
</section>
<footer class="row">
	<p>
		<b>FYP4U</b>
	</p>
</footer>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</body>
</html>