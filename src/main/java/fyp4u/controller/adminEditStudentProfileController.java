package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fyp4u.dao.StudentDAO;
import fyp4u.model.Student;

/**
 * Servlet implementation class adminEditStudentProfileController
 */
@WebServlet("/adminEditStudentProfileController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class adminEditStudentProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminEditStudentProfileController() {
		super();
		dao = new StudentDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("stuid"));
		request.setAttribute("student", StudentDAO.getStudentById(userid));
		RequestDispatcher view = request.getRequestDispatcher("admin/adminEditStudentProfile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStuID(Integer.parseInt(request.getParameter("stuID")));
		student.setStuName(request.getParameter("stuName"));
		student.setStuSemester(Integer.parseInt(request.getParameter("stuSemester")));
		student.setStuTelegram(request.getParameter("stuTelegram"));
		student.setStuCourse(request.getParameter("stuCourse"));
		student.setStuFaculty(request.getParameter("stuFaculty"));
		student.setStuPhoneNum(request.getParameter("stuPhoneNum"));
		student.setUserID(Integer.parseInt(request.getParameter("userID")));
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("stuImage");
        if (filePart.getSize() > 0) {
            // obtains input stream of the upload file
            student.setStuImage(filePart.getInputStream());
         // invoke the method dao and pass the object (product) to ProductDAO.java
    		dao.updateStudentByUserId(student);
        }
        else {
        	// invoke the method dao and pass the object (product) to ProductDAO.java
    		dao.updateStudentByUserIdWithoutImage(student);
        }

		// forward request (to other page)
		request.setAttribute("students", StudentDAO.getAllStudents());
		RequestDispatcher view = request.getRequestDispatcher("admin/listStudent.jsp");
		view.forward(request, response);
	}

}
