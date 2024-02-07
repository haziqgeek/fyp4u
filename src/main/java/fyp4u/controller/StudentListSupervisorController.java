package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.SupervisorDAO;

/**
 * Servlet implementation class StudentViewListSupervisorController
 */
@WebServlet("/StudentListSupervisorController")
public class StudentListSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupervisorDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListSupervisorController() {
        super();
        dao = new SupervisorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());
		RequestDispatcher view = request.getRequestDispatcher("student/studentListSupervisor.jsp");
		view.forward(request, response);
	}

}
