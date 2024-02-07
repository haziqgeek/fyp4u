package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fyp4u.dao.SupervisorDAO;
import fyp4u.model.Supervisor;

/**
 * Servlet implementation class EditSupervisorController
 */
@WebServlet("/adminEditSupervisorController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class adminEditSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupervisorDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminEditSupervisorController() {
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
		int supid = Integer.parseInt(request.getParameter("supId"));
		request.setAttribute("supervisor", SupervisorDAO.getSupervisorById(supid));
		RequestDispatcher view = request.getRequestDispatcher("admin/adminEditSupervisorProfile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Supervisor supervisor = new Supervisor();
		supervisor.setSupID(Integer.parseInt(request.getParameter("supid")));
		supervisor.setSupName(request.getParameter("supname"));
		supervisor.setSupFaculty(request.getParameter("supfaculty"));
		supervisor.setSupPhoneNum(request.getParameter("supphonenum"));
		supervisor.setSupTelegram(request.getParameter("suptelegram"));
		supervisor.setUserID(Integer.parseInt(request.getParameter("userid")));
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("supimage");
        if (filePart.getSize() > 0) {
            // obtains input stream of the upload file
            supervisor.setSupImage(filePart.getInputStream());
         // invoke the method dao and pass the object (product) to ProductDAO.java
    		dao.updateSupervisorByUserId(supervisor);
        }
        else {
        	supervisor.setSupImage(null);
        	// invoke the method dao and pass the object (product) to ProductDAO.java
    		dao.updateSupervisorByUserIdWithoutImage(supervisor);
        }

		// forward request (to other page)
		//int supid = Integer.parseInt(request.getParameter("supid"));
		request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());
		RequestDispatcher view = request.getRequestDispatcher("admin/listSupervisor.jsp");
		view.forward(request, response);
	}

}
