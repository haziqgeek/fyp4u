package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.StudentDAO;
import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.User;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao;
	String action = "", forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserController() {
		super();
		dao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		forward = "admin/registerUser.jsp";
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		// retrieve input and set
		// user.setId(Integer.parseInt(request.getParameter("id")));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));

		user = UserDAO.getUser(user);
		// check if user exists
		if (!user.isValid()) {
			try {
				// if user not exist, add/register the user
				dao.add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (user.getRole().equalsIgnoreCase("student")) {
				User newUser = new User();
				newUser = UserDAO.getUserByEmail(user.getEmail());
				request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));
				request.setAttribute("student", StudentDAO.getStudentByUserId(newUser.getUserid()));
				RequestDispatcher view = request.getRequestDispatcher("admin/adminEditStudentProfile.jsp");
				view.forward(request, response);
			} else {
				User newUser = new User();
				newUser = UserDAO.getUserByEmail(user.getEmail());
				request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));
				request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(newUser.getUserid()));
				RequestDispatcher view = request.getRequestDispatcher("admin/adminEditSupervisorProfile.jsp");
				view.forward(request, response);
			} 
			
			/*// redirect to login page
			int adminid = Integer.parseInt(request.getParameter("userid"));
			request.setAttribute("admin", AdminDAO.getAdminByUserId(adminid));
			RequestDispatcher view = request.getRequestDispatcher("adminDashboard.jsp"); // admin page
			view.forward(request, response);*/
		}
	}

}