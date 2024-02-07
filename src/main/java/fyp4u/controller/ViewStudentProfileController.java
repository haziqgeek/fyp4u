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
 * Servlet implementation class ViewStudentProfileController
 */
@WebServlet("/ViewStudentProfileController")
public class ViewStudentProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentProfileController() {
        super();
        dao = new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int stuid, userid;
		if(request.getParameter("userid") != null) {
			userid = Integer.parseInt(request.getParameter("userid"));
			request.setAttribute("student", StudentDAO.getStudentByUserId(userid));
		}
		else if(request.getParameter("stuid") != null) {
			stuid = Integer.parseInt(request.getParameter("stuid"));
			request.setAttribute("student", StudentDAO.getStudentById(stuid));
		}
			
		RequestDispatcher view = request.getRequestDispatcher("student/viewStudentProfile.jsp");
		view.forward(request, response);
	}

}
