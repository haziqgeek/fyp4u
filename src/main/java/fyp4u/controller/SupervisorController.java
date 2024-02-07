package fyp4u.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.Supervisor;

/**
 * Servlet implementation class SupervisorController
 */
@WebServlet("/SupervisorController")
public class SupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SupervisorDAO dao;
	private int supId;
	private String forward;
	private static String LIST = "admin/listSupervisor.jsp";
	private static String VIEW = "admin/viewSupervisorProfile.jsp";	
	private static String UPDATE = "admin/updateSupervisor.jsp";
	//private static String LISTALL = "staff/listAll.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorController() {
        super();
        dao = new SupervisorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listSupervisor")) {
			forward = LIST;
	        request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());       
		}		
		/*if(action.equalsIgnoreCase("listSupervisorByUserId")) {
			forward = LISTALL;
			request.setAttribute("supervisors", SupervisorDAO.getSupervisorById());
		}*/
		if(action.equalsIgnoreCase("viewSupervisorProfile")) { 
			forward = VIEW;
			supId = Integer.parseInt(request.getParameter("supId"));  
	        request.setAttribute("supervisors", SupervisorDAO.getSupervisorById(supId));
		}
		if(action.equalsIgnoreCase("updateSupervisor")) {
			forward = UPDATE;
			Supervisor supervisor = new Supervisor();			
			supId = Integer.parseInt(request.getParameter("supId"));    	        
			supervisor = SupervisorDAO.getSupervisorById(supId);	        	       
	        //request.setAttribute("selectedSupplier", supervisor.getUserId()); 	      	       	                
	        request.setAttribute("supervisor", SupervisorDAO.getSupervisorById(supId)); 
			request.setAttribute("users", UserDAO.getUserId());	        
		}
		if(action.equalsIgnoreCase("deleteSupervisor")) {
			forward = LIST;
			supId = Integer.parseInt(request.getParameter("supId"));  
			dao.deleteSupervisor(supId);
			request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());    
		}		
         
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Supervisor supervisor = new Supervisor();
		supervisor.setSupName(request.getParameter("supName"));
		supervisor.setSupPhoneNum(request.getParameter("supPhoneNum"));
		supervisor.setSupFaculty(request.getParameter("supFaculty"));
		supervisor.setUserID(Integer.parseInt(request.getParameter("userid")));
		
		String supId = request.getParameter("supId");
	    
	    if(supId ==null || supId.isEmpty()) {
	    	dao.addSupervisor(supervisor);
		}
		else {
			supervisor.setSupID(Integer.parseInt(supId));
			dao.updateSupervisor(supervisor);
		}
	    
	    request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());
	    RequestDispatcher view = request.getRequestDispatcher("admin/listSupervisor.jsp");
        view.forward(request, response);
	}

}
