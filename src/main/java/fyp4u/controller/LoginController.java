package fyp4u.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fyp4u.dao.AdminDAO;
import fyp4u.dao.StudentDAO;
import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao;
	private static StudentDAO sdao;
	private static SupervisorDAO pdao;
    HttpSession session;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new UserDAO();
        sdao = new StudentDAO();
        pdao = new SupervisorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            User user = new User();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user = UserDAO.login(user);
            if (user.isValid()) {
                this.session = request.getSession(true);
                this.session.setAttribute("sessionId", user.getUserid());
                System.out.println(user.getUserid());
                this.session.setAttribute("sessionEmail", user.getEmail());
                this.session.setAttribute("sessionRole", user.getRole());
            
                if (user.getRole().equalsIgnoreCase("student")) {
                	request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));
                	request.setAttribute("student", StudentDAO.getStudentByUserId(user.getUserid()));
            		RequestDispatcher view = request.getRequestDispatcher("student/viewStudentDashboard.jsp");
                    view.forward(request, response);
                } else if(user.getRole().equalsIgnoreCase("supervisor")){
                    request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));
                    request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(user.getUserid()));
                    RequestDispatcher view = request.getRequestDispatcher("supervisor/viewSupervisorDashboard.jsp");
                    view.forward(request, response);
                } else {
                    request.setAttribute("user", UserDAO.getUserByEmail(user.getEmail()));
                    request.setAttribute("admin", AdminDAO.getAdminByUserId(user.getUserid()));
                    RequestDispatcher view = request.getRequestDispatcher("admin/adminDashboard.jsp");
                    view.forward(request, response);
                }
            } else {
                response.sendRedirect("invalidLogin.jsp");
            }
        } catch (Throwable var5) {
            System.out.println(var5);
        }

    }

}
