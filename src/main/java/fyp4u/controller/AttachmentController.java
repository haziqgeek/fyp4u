package fyp4u.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.ProjectDAO;

/**
 * Servlet implementation class AttachmentController
 */
@WebServlet("/AttachmentController")
public class AttachmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProjectDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttachmentController() {
        super();
        dao = new ProjectDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		byte[] imgData;
		if (type.equals("proposal"))
			imgData = dao.getProposalAttachment(Integer.parseInt(id));
		else
			imgData = dao.getProjectAttachment(Integer.parseInt(id));
		OutputStream output = response.getOutputStream();
		response.setContentType("application/pdf");
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
