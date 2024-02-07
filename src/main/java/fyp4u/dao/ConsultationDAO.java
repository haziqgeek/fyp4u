package fyp4u.dao;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import fyp4u.connection.ConnectionManager;
import fyp4u.model.Consultation;


public class ConsultationDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	private String platform, description, status;
	private Date consultDate;
	private Time consultTime;
	private int consultID, stuID, supID;
	//add consultation (every new consultation made by student)
	public void addConsultation(Consultation bean) {
		supID = bean.getSupID();
		stuID = bean.getStuID();
		platform = bean.getPlatform();
		description = bean.getDescription();
		status = bean.getStatus();
		consultDate = (Date) bean.getConsultDate();
		consultTime = bean.getConsultTime();
		
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into consultation ( SupID, StuID, platform, description, status, consultDate, consultTime) values (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,supID);
			ps.setInt(2,stuID);
			ps.setString(3, platform);
			ps.setString(4, description);
			ps.setString(5, status);
			ps.setDate(6, consultDate);
			ps.setTime(7, consultTime);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//get all consultation
	public static List<Consultation> getAllConsultations(){
		List<Consultation> consultation = new ArrayList<Consultation>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			String sql ="select * from consultation order by consultID";
			
			rs = stmt.executeQuery(sql);
			//ps = con.prepareStatement(sql);
			while(rs.next()) {
				Consultation consult = new Consultation();
				consult.setConsultID(rs.getInt("consultID"));
				consult.setStuID(rs.getInt("stuID"));
				consult.setSupID(rs.getInt("supID"));
				consult.setPlatform(rs.getString("platform"));
				consult.setDescription(rs.getString("description"));
				consult.setStatus(rs.getString("status"));
				consult.setConsultDate(rs.getDate("consultDate"));
				consult.setConsultTime(rs.getTime("consultTime"));
				consultation.add(consult);
		}
		con.close();	
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return consultation;
	}
	
	//get consultation by consultID
	public static Consultation getConsultationByID (int consultID) {
		Consultation consult = new Consultation();
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from consultation where consultID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, consultID);
			rs = ps.executeQuery();
			if(rs.next()) {
				consult.setConsultID(rs.getInt("consultID"));
				consult.setStuID(rs.getInt("stuID"));
				consult.setSupID(rs.getInt("supID"));
				consult.setPlatform(rs.getString("platform"));
				consult.setDescription(rs.getString("description"));
				consult.setStatus(rs.getString("status"));
				consult.setConsultDate(rs.getDate("consultDate"));
				consult.setConsultTime(rs.getTime("consultTime"));
		}
		con.close();	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return consult;
	}
	
	//update consultation (when supervisor accept the consultation to add gmeet link)
	public void updateConsultation (Consultation bean) {
		consultID = bean.getConsultID();
		stuID = bean.getStuID();
		supID = bean.getSupID();
		platform = bean.getPlatform();
		description = bean.getDescription();
		status = bean.getStatus();
		consultDate = (Date) bean.getConsultDate();
		consultTime = (Time) bean.getConsultTime();
		
		
		try {
			con = ConnectionManager.getConnection();
			String sql = "update consultation set platform=?, status=? where consultID=?";
			ps = con.prepareStatement (sql);
			ps.setString(1, platform);
			ps.setString(2, status);
			ps.setInt(3, consultID);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	//get student name & supervisor name
	public static List<Consultation> getStudentSupervisor() { 
		List<Consultation> consultation = new ArrayList<Consultation>(); 
		try { 
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("SELECT ConsultID, ConsultDate, ConsultTime, Platform, Description, status, c.StuID , c.SupID, s.SupName, t.StuName FROM supervisor s JOIN consultation c ON c.SupID = s.SupID JOIN student t ON  c.StuID= t.StuID");

			while (rs.next()) { 
				Consultation consult = new Consultation();
				consult.setConsultID(rs.getInt("consultID"));
				consult.setStuID(rs.getInt("stuID"));
				consult.setSupID(rs.getInt("supID"));
				consult.setPlatform(rs.getString("platform"));
				consult.setDescription(rs.getString("description"));
				consult.setStatus(rs.getString("status"));
				consult.setConsultDate(rs.getDate("consultdate"));
				consult.setConsultTime(rs.getTime("consulttime"));
				consult.setStudent(StudentDAO.getStudentById(rs.getInt("stuID")));
				consult.setSupervisor(SupervisorDAO.getSupervisorById(rs.getInt("supID")));
				consultation.add(consult);

			} 
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return consultation;
		}
	
		//get student name & supervisor name
		public static List<Consultation> getStudentSupervisorBySupId(int supID) { 
			List<Consultation> consultation = new ArrayList<Consultation>(); 
			try { 
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				stmt = con.createStatement(); 
				String sql = "SELECT ConsultID, ConsultDate, ConsultTime, platform, description, status, c.StuID , c.SupID, s.SupName, t.StuName FROM supervisor s JOIN consultation c ON c.SupID = s.SupID JOIN student t ON  c.StuID= t.StuID where c.supID=?";
				//4. execute query
				ps = con.prepareStatement(sql);
				ps.setInt(1, supID);
				rs = ps.executeQuery();

				while (rs.next()) { 
					Consultation consult = new Consultation();
					consult.setConsultID(rs.getInt("consultID"));
					consult.setStuID(rs.getInt("stuID"));
					consult.setSupID(rs.getInt("supID"));
					consult.setPlatform(rs.getString("platform"));
					consult.setDescription(rs.getString("description"));
					consult.setStatus(rs.getString("status"));
					consult.setConsultDate(rs.getDate("consultdate"));
					consult.setConsultTime(rs.getTime("consulttime"));
					consult.setStudent(StudentDAO.getStudentById(rs.getInt("stuID")));
					consult.setSupervisor(SupervisorDAO.getSupervisorById(rs.getInt("supID")));
					consultation.add(consult);

				} 
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}

		return consultation; 
	}
		
		public static int getLatestStudentConsultationID(int stuID) {
			int consultID = 0;
			try { 
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				stmt = con.createStatement(); 
				String sql = "SELECT ConsultID from consultation where stuID=? ORDER BY ConsultDate DESC LIMIT 1";
				//4. execute query
				ps = con.prepareStatement(sql);
				ps.setInt(1, stuID);
				rs = ps.executeQuery();

				if (rs.next()) { 
					consultID = rs.getInt("consultID");

				} 
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}
			return consultID;
		}
	
}	
