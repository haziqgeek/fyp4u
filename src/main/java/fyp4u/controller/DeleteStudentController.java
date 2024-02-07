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
 * Servlet implementation class DeleteStudentController
 */
@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentController() {
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
		dao.deleteStudent(stuid);
		request.setAttribute("students", StudentDAO.getAllStudents());	
		RequestDispatcher view = request.getRequestDispatcher("admin/listStudent.jsp");
		view.forward(request, response);
	}

}
