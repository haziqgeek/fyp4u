package fyp4u.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import fyp4u.connection.ConnectionManager;
import fyp4u.model.Project;

public class ProjectDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static Blob blob;
	String projTitle, status, projDescription;
	InputStream projAttachment, proposalattachment;
	Date submissionDate, deadline;
	int stuID, supID, projID, score;

	// get all project
	public static List<Project> getAllProjects() {
		List<Project> project = new ArrayList<Project>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();
			// 3. create statement
			stmt = con.createStatement();
			// 4. execute query
			rs = stmt.executeQuery(
					"select stuID, supID, projID, projTitle, status, submissionDate, deadline, score, projdescription from project order by projID");

			while (rs.next()) {
				Project proj = new Project();
				proj.setStuID(rs.getInt("stuID"));
				proj.setSupID(rs.getInt("supID"));
				proj.setProjID(rs.getInt("projID"));
				proj.setProjTitle(rs.getString("projTitle"));
				proj.setStatus(rs.getString("status"));
				proj.setSubmissionDate(rs.getDate("submissionDate"));
				proj.setDeadline(rs.getDate("deadline"));
				proj.setScore(rs.getInt("score"));
				proj.setProjDescription(rs.getString("projDescription"));
				project.add(proj);

			}
			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return project;
	}
	// get all project
		public static List<Project> getProjectsBySupID(int supID) {
			List<Project> project = new ArrayList<Project>();
			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();
				// 3. create statement
				stmt = con.createStatement();
				// 3. create statement
				ps = con.prepareStatement(
						"SELECT p.StuID, p.SupID, ProjID, p.ProjTitle, p.ProjDescription, p.ProposalAttachment, p.ProjAttachment, p.Status, p.SubmissionDate, p.Deadline, p.Score, s.StuName, s.StuCourse FROM project p INNER JOIN student s ON p.StuID = s.StuID WHERE SupID=?;");
				ps.setInt(1, supID);
				// 4. execute query
				rs = ps.executeQuery();

				while (rs.next()) {
					Project proj = new Project();
					proj.setStuID(rs.getInt("stuID"));
					proj.setSupID(rs.getInt("supID"));
					proj.setProjID(rs.getInt("projID"));
					proj.setProjTitle(rs.getString("projTitle"));
					proj.setStatus(rs.getString("status"));
					proj.setSubmissionDate(rs.getDate("submissionDate"));
					proj.setDeadline(rs.getDate("deadline"));
					proj.setScore(rs.getInt("score"));
					proj.setProjDescription(rs.getString("projDescription"));
					proj.setStudent(StudentDAO.getStudentById(rs.getInt("stuID")));
					project.add(proj);

				}
				// 5. close connection
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

			return project;
		}

	// get project by projID
	public static Project getProjectByID(int projID) {
		Project proj = new Project();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();
			// 3. create statement
			ps = con.prepareStatement(
					"select stuID, supID, projID, projTitle, status, submissionDate, deadline, score, projDescription from project where projID=?");
			ps.setInt(1, projID);
			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				proj.setStuID(rs.getInt("stuID"));
				proj.setSupID(rs.getInt("supID"));
				proj.setProjID(rs.getInt("projID"));
				proj.setProjTitle(rs.getString("projTitle"));
				proj.setStatus(rs.getString("status"));
				proj.setSubmissionDate(rs.getDate("submissionDate"));
				proj.setDeadline(rs.getDate("deadline"));
				proj.setScore(rs.getInt("score"));
				proj.setProjDescription(rs.getString("projDescription"));
			}
			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return proj;
	}
	// get project by projID
		public static Project getProjectByStuID(int stuID) {
			Project proj = new Project();
			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();
				// 3. create statement
				ps = con.prepareStatement(
						"select stuID, supID, projID, projTitle, status, submissionDate, deadline, score, projDescription from project where stuID=?");
				ps.setInt(1, stuID);
				// 4. execute query
				rs = ps.executeQuery();
				if (rs.next()) {
					proj.setStuID(rs.getInt("stuID"));
					proj.setSupID(rs.getInt("supID"));
					proj.setProjID(rs.getInt("projID"));
					proj.setProjTitle(rs.getString("projTitle"));
					proj.setStatus(rs.getString("status"));
					proj.setSubmissionDate(rs.getDate("submissionDate"));
					proj.setDeadline(rs.getDate("deadline"));
					proj.setScore(rs.getInt("score"));
					proj.setProjDescription(rs.getString("projDescription"));
				}
				// 5. close connection
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

			return proj;
		}

	// delete project
	public void delete(int projID) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();
			// create statement
			ps = con.prepareStatement("delete from project where projID=?");
			ps.setInt(1, projID);
			// execute query
			ps.executeUpdate();
			// close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// add project
	public void add(Project bean) {
		projTitle = bean.getProjTitle();
		status = bean.getStatus();
		projAttachment = bean.getProjAttachment();
		submissionDate = bean.getSubmissionDate();
		deadline = bean.getDeadline();
		stuID = bean.getStuID();
		supID = bean.getSupID();
		projID = bean.getProjID();
		score = bean.getScore();
		projDescription = bean.getProjDescription();

		try {
			// call getConnection() method //3. create statement //4. execute query
			con = ConnectionManager.getConnection();
			// 3. create statement
			ps = con.prepareStatement(
					"insert into project(stuid,supid,projid,projtitle,projattachment,status,submissiondate,deadline,score,projDescription) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, stuID);
			ps.setInt(2, supID);
			ps.setInt(3, projID);
			ps.setString(4, projTitle);
			ps.setBlob(5, projAttachment);
			ps.setString(6, status);
			ps.setDate(7, submissionDate);
			ps.setDate(8, deadline);
			ps.setInt(9, score);
			ps.setString(10, projDescription);
			// 4. execute query
			ps.executeUpdate();
			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	// add project
		public void propose(Project bean) {
			projTitle = bean.getProjTitle();
			status = bean.getStatus();
			proposalattachment = bean.getProposalAttachment();
			submissionDate = bean.getSubmissionDate();
			deadline = bean.getDeadline();
			stuID = bean.getStuID();
			supID = bean.getSupID();
			projID = bean.getProjID();
			score = bean.getScore();
			projDescription = bean.getProjDescription();

			try {
				// call getConnection() method //3. create statement //4. execute query
				con = ConnectionManager.getConnection();
				// 3. create statement
				ps = con.prepareStatement(
						"insert into project(stuid,supid,projid,projtitle,proposalattachment,projDescription) values(?,?,?,?,?,?)");
				ps.setInt(1, stuID);
				ps.setInt(2, supID);
				ps.setInt(3, projID);
				ps.setString(4, projTitle);
				ps.setBlob(5, proposalattachment);
				ps.setString(6, projDescription);
				// 4. execute query
				ps.executeUpdate();
				// 5. close connection
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	// update project
	public void update(Project bean) {

		projTitle = bean.getProjTitle();
		status = bean.getStatus();
		projAttachment = bean.getProjAttachment();
		submissionDate = bean.getSubmissionDate();
		deadline = bean.getDeadline();
		stuID = bean.getStuID();
		supID = bean.getSupID();
		projID = bean.getProjID();
		score = bean.getScore();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();
			// 3. create statement
			ps = con.prepareStatement(
					"update project set stuid=?,supid=?,projtitle=?,projattachment=?,status=?,submissiondate=?,deadline=?,score=? WHERE projID=?");
			ps.setInt(1, stuID);
			ps.setInt(2, supID);
			ps.setString(3, projTitle);
			ps.setBlob(4, projAttachment);
			ps.setString(5, status);
			ps.setDate(6, submissionDate);
			ps.setDate(7, deadline);
			ps.setInt(8, score);
			ps.setInt(9, projID);
			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	// update Status
		public void updateStatus(String status, int projID) {

			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();
				// 3. create statement
				ps = con.prepareStatement(
						"update project set status=? WHERE projID=?");
				ps.setInt(2, projID);
				ps.setString(1, status);
				// 4. execute query
				ps.executeUpdate();

				// 5. close connection
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		// update Status
				public void updateScore(Date deadline, int score, int projID) {

					try {
						// call getConnection() method
						con = ConnectionManager.getConnection();
						// 3. create statement
						ps = con.prepareStatement(
								"update project set score=?, deadline=? WHERE projID=?");
						ps.setInt(3, projID);
						ps.setDate(2, deadline);
						ps.setInt(1, score);
						
						// 4. execute query
						ps.executeUpdate();

						// 5. close connection
						con.close();
					} catch (Exception e) {
						e.printStackTrace();

					}
				}
		
		public void addProjectAttachment(Project bean) {
			projAttachment = bean.getProjAttachment();
			projID = bean.getProjID();

			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();
				// 3. create statement
				ps = con.prepareStatement(
						"update project set projattachment=?, status='Submitted', SubmissionDate=NOW() WHERE projID=?");
				ps.setBlob(1, projAttachment);
				ps.setInt(2, projID);
				// 4. execute query
				ps.executeUpdate();

				// 5. close connection
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	// get proposal attachment
	public byte[] getProposalAttachment(int projID) {
		byte[] attachmentData = null;
		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT proposalAttachment FROM project WHERE ProjID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, projID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				blob = rs.getBlob("proposalAttachment");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1000000];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				attachmentData = outputStream.toByteArray();
				inputStream.close();
				outputStream.close();
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return attachmentData;
	}
	
	// get project attachment
		public byte[] getProjectAttachment(int projID) {
			byte[] attachmentData = null;
			try {
				// call getConnection() method from ConnectionManager class
				con = ConnectionManager.getConnection();

				// 3. create statement
				String sql = "SELECT projAttachment FROM project WHERE ProjID=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, projID);

				// 4. execute query
				rs = ps.executeQuery();
				if (rs.next()) {
					blob = rs.getBlob("projAttachment");
					InputStream inputStream = blob.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[1000000];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					attachmentData = outputStream.toByteArray();
					inputStream.close();
					outputStream.close();
				}

				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			return attachmentData;
		}
		public boolean isExists(int stuID)
		{
			boolean isExists = false;
			try {
				// call getConnection() method from ConnectionManager class
				con = ConnectionManager.getConnection();

				// 3. create statement
				String sql = "SELECT * FROM project WHERE stuID=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, stuID);

				// 4. execute query
				rs = ps.executeQuery();
				if (!rs.next()) {
					isExists = false;
				}
				else {
					isExists = true;
				}

				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			return isExists;
		}
}
