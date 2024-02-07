package fyp4u.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.SupervisorDAO;

/**
 * Servlet implementation class SupervisorImageController
 */
@WebServlet("/SupervisorImageController")
public class SupervisorImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupervisorDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorImageController() {
        super();
        dao = new SupervisorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		byte[] imgData = dao.getImageFromID(Integer.parseInt(id));
		OutputStream output = response.getOutputStream();
		response.setContentType("image/png");
		output.write(imgData);
		output.flush();
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
