package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fyp4u.dao.ProjectDAO;
import fyp4u.model.Project;

/**
 * Servlet implementation class ProposalController
 */
@WebServlet("/ProposalController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class ProposalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProjectDAO dao;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProposalController() {
        super();
        dao = new ProjectDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Project proj = new Project();
		proj.setStuID(Integer.parseInt(request.getParameter("stuID")));
		proj.setSupID(Integer.parseInt(request.getParameter("supID")));
		proj.setProjTitle(request.getParameter("projTitle"));
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("attachment");
        if (filePart != null) {
            // obtains input stream of the upload file
            proj.setProposalAttachment(filePart.getInputStream());
        }
		proj.setProjDescription(request.getParameter("projDescription"));
	    
		dao.propose(proj);
		
		request.setAttribute("proj", ProjectDAO.getProjectByStuID(Integer.parseInt(request.getParameter("stuID"))));
	    RequestDispatcher view = request.getRequestDispatcher("student/project/index.jsp");
        view.forward(request, response);
	}

}
