package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.Supervisor;

/**
 * Servlet implementation class EditSupervisorController
 */
@WebServlet("/EditSupervisorController")
public class EditSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupervisorDAO dao;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditSupervisorController() {
		super();
		dao = new SupervisorDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int supid = Integer.parseInt(request.getParameter("supid"));
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		request.setAttribute("supervisor", SupervisorDAO.getSupervisorById(supid));
		request.setAttribute("user", UserDAO.getUserById(userId));
		RequestDispatcher view = request.getRequestDispatcher("supervisor/editSupervisorProfile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		Supervisor supervisor = new Supervisor();
		supervisor.setSupID(Integer.parseInt(request.getParameter("supID")));
		supervisor.setSupName(request.getParameter("supName"));
		supervisor.setSupFaculty(request.getParameter("supFaculty"));
		supervisor.setSupPhoneNum(request.getParameter("supPhoneNum"));
		supervisor.setSupTelegram(request.getParameter("supTelegram"));
		supervisor.setUserID(Integer.parseInt(request.getParameter("userID")));

		// invoke the method dao and pass the object (product) to ProductDAO.java
		dao.updateSupervisorByUserId(supervisor);

		// forward request (to other page)
		int supid = Integer.parseInt(request.getParameter("supID"));
		request.setAttribute("supervisor", SupervisorDAO.getSupervisorById(supid));
		request.setAttribute("user", UserDAO.getUserById(userId));
		RequestDispatcher view = request.getRequestDispatcher("supervisor/viewSupervisorProfile.jsp");
		view.forward(request, response);
	}

}
