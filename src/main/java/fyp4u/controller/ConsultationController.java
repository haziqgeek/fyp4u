package fyp4u.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fyp4u.dao.ConsultationDAO;
import fyp4u.dao.ProjectDAO;
import fyp4u.dao.StudentDAO;
import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.Consultation;


/**
 * Servlet implementation class ConsultationController
 */
@WebServlet("/ConsultationController")
public class ConsultationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ConsultationDAO dao;
	DateFormat formatter;
	DateFormat formatter1;
	private int consultID ;
	private String forward;
	String action;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultationController() {
        super();
        dao = new ConsultationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		
		if (action.equalsIgnoreCase("listConsultation")) {
			forward = "supervisor/consultation/index.jsp";
			int supid = SupervisorDAO.getSupervisorByUserId(userId).getSupID();
			request.setAttribute("consultation", ConsultationDAO.getStudentSupervisorBySupId(supid));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		if (action.equalsIgnoreCase("listConsultationForStudent")) {
			forward = "student/consultation/details.jsp";
			int stuID = StudentDAO.getStudentByUserId(userId).getStuID();
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("consultation", ConsultationDAO.getAllConsultations());
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		
		if(action.equalsIgnoreCase("viewConsultationforSupervisor")) {
			forward = "supervisor/consultation/details.jsp";
			consultID = Integer.parseInt(request.getParameter("consultID"));
			request.setAttribute("consultation", ConsultationDAO.getConsultationByID(consultID));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		
		if(action.equalsIgnoreCase("viewReminder")) {
			forward = "student/consultation/reminder.jsp";
			consultID = Integer.parseInt(request.getParameter("consultID"));
			request.setAttribute("consult", ConsultationDAO.getConsultationByID(consultID));
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		
		if(action.equalsIgnoreCase("updateConsultation")) {
			forward = "supervisor/consultation/booking.jsp";
			consultID = Integer.parseInt(request.getParameter("consultID"));
			request.setAttribute("consult", ConsultationDAO.getConsultationByID(consultID));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		
		if(action.equalsIgnoreCase("addConsultation")) {
			forward = "student/consultation/booking.jsp";
			//request.setAttribute("consultation", ConsultationDAO.getAllConsultations());
			int stuId = StudentDAO.getStudentByUserId(userId).getStuID();
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("project", ProjectDAO.getProjectByStuID(stuId));
		}
		
		if(action.equalsIgnoreCase("index")) {
			forward = "student/consultation/index.jsp";
			//request.setAttribute("consultation", ConsultationDAO.getAllConsultations());
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter1 = new SimpleDateFormat("HH:mm");
		java.util.Date date1=formatter.parse(request.getParameter("consultDate"));
		java.util.Date time1=formatter1.parse(request.getParameter("consultTime"));
		//convert to sql date
		java.sql.Date sqlDate = new Date(date1.getTime());
		java.sql.Time sqlTime = new Time(time1.getTime());
		
		Consultation consult = new Consultation();
		consult.setStuID(Integer.parseInt(request.getParameter("stuID")));
		consult.setSupID(Integer.parseInt(request.getParameter("supID")));
		consult.setDescription(request.getParameter("description"));
		consult.setPlatform(request.getParameter("platform"));
		consult.setStatus(request.getParameter("status"));
		consult.setConsultDate(sqlDate);
		consult.setConsultTime(sqlTime);		
		String consultID = request.getParameter("consultID");
		
		if (consultID == null || consultID.isEmpty()) {
			dao.addConsultation(consult);
			RequestDispatcher view = request.getRequestDispatcher("student/consultation/index.jsp");
	        view.forward(request, response);
		}
		else {
			consult.setConsultID(Integer.parseInt(consultID));
			dao.updateConsultation(consult);
			request.setAttribute("consultation", ConsultationDAO.getStudentSupervisor());
		    RequestDispatcher view = request.getRequestDispatcher("supervisor/consultation/index.jsp");
	        view.forward(request, response);
		}
        
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}