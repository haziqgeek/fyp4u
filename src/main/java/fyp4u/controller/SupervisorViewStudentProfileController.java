package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.StudentDAO;

/**
 * Servlet implementation class SupervisorViewStudentProfileController
 */
@WebServlet("/SupervisorViewStudentProfileController")
public class SupervisorViewStudentProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorViewStudentProfileController() {
        super();
        dao = new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", StudentDAO.getStudentById(sid));
		RequestDispatcher view = request.getRequestDispatcher("supervisor/supervisorViewStudentProfile.jsp");
		view.forward(request, response);
	}

}
