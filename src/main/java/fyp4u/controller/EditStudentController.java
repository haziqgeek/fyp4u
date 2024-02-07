package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.StudentDAO;
import fyp4u.model.Student;

/**
 * Servlet implementation class EditStudentController
 */
@WebServlet("/EditStudentController")
public class EditStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentController() {
        super();
        dao = new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int stuid = Integer.parseInt(request.getParameter("stuid"));
		request.setAttribute("student", StudentDAO.getStudentById(stuid));
		RequestDispatcher view = request.getRequestDispatcher("student/editStudentProfile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStuID(Integer.parseInt(request.getParameter("stuid")));
		student.setStuName(request.getParameter("stuname"));
		student.setStuSemester(Integer.parseInt(request.getParameter("stusemester")));
		student.setStuCourse(request.getParameter("stucourse"));
		student.setStuFaculty(request.getParameter("stufaculty"));
		student.setStuPhoneNum(request.getParameter("stuphonenum"));
		student.setStuTelegram(request.getParameter("stutelegram"));
		student.setUserID(Integer.parseInt(request.getParameter("userid")));
		
		//invoke the method dao and pass the object (product) to ProductDAO.java
		dao.updateStudentByUserId(student);
		
		//forward request (to other page)
		int stuid = Integer.parseInt(request.getParameter("stuid"));
		request.setAttribute("student", StudentDAO.getStudentById(stuid));
		RequestDispatcher view = request.getRequestDispatcher("student/viewStudentProfile.jsp");
		view.forward(request, response);
	}

}
