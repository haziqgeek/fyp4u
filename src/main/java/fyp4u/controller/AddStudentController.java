package fyp4u.controller;

import java.io.IOException;
import java.io.InputStream;

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
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
        super();
        dao = new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStuID(Integer.parseInt(request.getParameter("StuID")));
		student.setStuName(request.getParameter("StuName"));
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("StuImage");
        if (filePart != null) {
            // obtains input stream of the upload file
            student.setStuImage(filePart.getInputStream());
        }
		student.setStuPhoneNum(request.getParameter("StuPhoneNum"));
		student.setStuCourse(request.getParameter("StuCourse"));
		student.setStuFaculty(request.getParameter("StuFaculty"));
		dao.addStudent(student);
		
		//forward request (to other page)
		request.setAttribute("students", StudentDAO.getAllStudents());
		RequestDispatcher view = request.getRequestDispatcher("listStudent.jsp");
		view.forward(request, response);
	}

}
