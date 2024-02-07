package fyp4u.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fyp4u.dao.ProjectDAO;
import fyp4u.dao.StudentDAO;
import fyp4u.dao.UserDAO;

/**
 * Servlet implementation class ProjectEvaluationController
 */
@WebServlet("/ProjectEvaluationController")
public class ProjectEvaluationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO dao;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectEvaluationController() {
        super();
        dao = new ProjectDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int score = Integer.parseInt(request.getParameter("score"));
		int projID = Integer.parseInt(request.getParameter("projID"));
		java.util.Date deadline = null;
		java.sql.Date sqlDate = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			deadline = formatter.parse(request.getParameter("deadline"));
			sqlDate = new java.sql.Date(deadline.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		dao.updateScore(sqlDate, score, projID);
		request.setAttribute("proj", ProjectDAO.getProjectByID(projID));
	    request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
	    request.setAttribute("user", UserDAO.getUserById(userId));
	    RequestDispatcher view = request.getRequestDispatcher("supervisor/project/index.jsp");
        view.forward(request, response);
	}

}
