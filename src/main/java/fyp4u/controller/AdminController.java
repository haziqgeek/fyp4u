package fyp4u.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fyp4u.dao.AdminDAO;
import fyp4u.model.Admin;


/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AdminDAO dao;
	private int adminId;
	private String forward;
	private static String VIEW = "admin/adminDashboard.jsp";	
	private static String EDIT = "admin/updateprofile.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("adminDashboard")) { 
			forward = VIEW;
			adminId = Integer.parseInt(request.getParameter("adminId"));  
	        request.setAttribute("admin", AdminDAO.getAdminById(adminId));
		}
		
		if(action.equalsIgnoreCase("updateprofile")) {
			forward = EDIT;
			Admin admin = new Admin();			
			adminId = Integer.parseInt(request.getParameter("adminId"));    	        
			admin = AdminDAO.getAdminById(adminId);	        	       
			//admin.setAttribute("selectedSupplier", product.getSid()); 	      	       	                
	        request.setAttribute("admin", AdminDAO.getAdminById(adminId)); 
			//request.setAttribute("sups", SupplierDAO.getAllSupplier());	        
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		admin.setAdminUsername(request.getParameter("adminUsername"));	  
		admin.setAdminPhonenumber(request.getParameter("adminPhoneNumber"));
		//prod.setSid(Integer.parseInt(request.getParameter("sid")));
		
		
		String adminId = request.getParameter("adminId");
	    
	    if(adminId ==null || adminId.isEmpty()) {
	    	dao.add(admin);
		}
		else {
			admin.setAdminID(Integer.parseInt(adminId));
			dao.updateAdmin(admin);
		}
	    
	    request.setAttribute("admins", AdminDAO.getAllAdmin());
	    RequestDispatcher view = request.getRequestDispatcher("adminDashboard.jsp");
        view.forward(request, response);
	}

}
