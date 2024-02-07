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
import fyp4u.dao.StudentDAO;
import fyp4u.dao.SupervisorDAO;
import fyp4u.dao.UserDAO;
import fyp4u.model.Project;
import fyp4u.model.Student;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet("/ProjectController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProjectDAO dao;
	private int id;
	private String forward;
	private static String LIST_ACCEPTED = "supervisor/project/list.jsp";
	private static String LIST_REVIEW = "supervisor/project/review.jsp";
	private static String VIEW = "student/project/index.jsp";
	private static String UPDATE = "staff/updateProduct.jsp";
	private static String ADD = "student/project/proposal.jsp";
	private static String SUPINDEX = "supervisor/project/index.jsp";
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectController() {
		super();
		dao = new ProjectDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		int stuId = StudentDAO.getStudentByUserId(userId).getStuID();
		
		if(dao.isExists(stuId)) {
			forward = VIEW;
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());
			request.setAttribute("proj", ProjectDAO.getProjectByStuID(stuId));
		}
		else {
			forward = ADD;
			request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisors", SupervisorDAO.getAllSupervisors());
		}
		
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("list")) {
			forward = LIST_ACCEPTED;
			int id = SupervisorDAO.getSupervisorByUserId(userId).getSupID();
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("projs", ProjectDAO.getProjectsBySupID(id));
		}
		if (action.equalsIgnoreCase("listReview")) {
			forward = LIST_REVIEW;
			int id = SupervisorDAO.getSupervisorByUserId(userId).getSupID();
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("projs", ProjectDAO.getProjectsBySupID(id));
		}
		if (action.equalsIgnoreCase("updateProject")) {
			forward = UPDATE;
			Project project = new Project();
			Student student = new Student();
			id = Integer.parseInt(request.getParameter("id"));
			project = ProjectDAO.getProjectByID(id);
			request.setAttribute("selectedStudent", student.getStuID());
			request.setAttribute("proj", ProjectDAO.getProjectByID(id));
			request.setAttribute("studs", StudentDAO.getAllStudents());
		}
		if (action.equalsIgnoreCase("deleteProject")) {
			forward = LIST_REVIEW;
			id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			request.setAttribute("projs", ProjectDAO.getAllProjects());
		}
		if (action.equalsIgnoreCase("supIndex")) {
			forward = SUPINDEX;
			int id = SupervisorDAO.getSupervisorByUserId(userId).getSupID();
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("projs", ProjectDAO.getProjectsBySupID(id));
		}
		if (action.equalsIgnoreCase("acceptProject")) {
			forward = LIST_REVIEW;
			id = Integer.parseInt(request.getParameter("id"));
			dao.updateStatus("In Progress", id);
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("projs", ProjectDAO.getAllProjects());
		}
		if (action.equalsIgnoreCase("evaluate")) {
			forward = "supervisor/project/evaluate.jsp";
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("proj", ProjectDAO.getProjectByID(id));
		}
		if (action.equalsIgnoreCase("deadline")) {
			forward = "supervisor/project/deadline.jsp";
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", UserDAO.getUserById(userId));
			request.setAttribute("supervisor", SupervisorDAO.getSupervisorByUserId(userId));
			request.setAttribute("proj", ProjectDAO.getProjectByID(id));
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.session = request.getSession();
		int userId = (Integer) session.getAttribute("sessionId");
		int stuId = StudentDAO.getStudentByUserId(userId).getStuID();
		Project proj = new Project();
		proj.setProjID(Integer.parseInt(request.getParameter("projID")));
		//proj.setSupID(Integer.parseInt(request.getParameter("supID")));
		//proj.setProjTitle(request.getParameter("projTitle"));
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("attachment");
        if (filePart != null) {
            // obtains input stream of the upload file
            proj.setProjAttachment(filePart.getInputStream());
        }
		//proj.setProjDescription(request.getParameter("projDescription"));
		
		//System.out.println(request.getParameter("stuID"));
		//System.out.println(request.getParameter("supID"));
		//System.out.println(request.getParameter("projDescription"));
		dao.addProjectAttachment(proj);
	    
	    request.setAttribute("proj", ProjectDAO.getProjectByStuID(stuId));
	    request.setAttribute("student", StudentDAO.getStudentByUserId(userId));
	    request.setAttribute("user", UserDAO.getUserById(userId));
	    RequestDispatcher view = request.getRequestDispatcher("student/project/index.jsp");
        view.forward(request, response);
	}

}
