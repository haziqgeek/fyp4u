package fyp4u.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fyp4u.connection.ConnectionManager;
import fyp4u.model.Supervisor;

public class SupervisorDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static Blob blob = null;

	int SupID, AdminID, UserID;
	InputStream SupImage;
	String SupName, SupPhoneNum, SupEmail, SupPassword, SupFaculty, SupTelegram;

	// add supervisor
	public void addSupervisor(Supervisor bean) {

		// get the supervisor
		SupID = bean.getSupID();
		SupName = bean.getSupName();
		SupPhoneNum = bean.getSupPhoneNum();
		SupFaculty = bean.getSupFaculty();
		SupImage = bean.getSupImage();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "INSERT INTO student(SupID, SupName, SupPhoneNum, SupEmail, SupPassword, SupFaculty, SupImage)VALUES(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupID);
			ps.setString(2, SupName);
			ps.setString(3, SupPhoneNum);
			ps.setString(4, SupEmail);
			ps.setString(5, SupPassword);
			ps.setString(6, SupFaculty);
			ps.setBlob(7, SupImage);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data inserted succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get supervisor by id
	public static Supervisor getSupervisorById(int SupID) {
		Supervisor supervisor = new Supervisor();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT * FROM supervisor WHERE SupID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				supervisor.setSupID(rs.getInt("SupID"));
				supervisor.setSupName(rs.getString("SupName"));
				supervisor.setSupPhoneNum(rs.getString("SupPhoneNum"));
				supervisor.setSupFaculty(rs.getString("SupFaculty"));
				supervisor.setSupTelegram(rs.getString("SupTelegram"));
				supervisor.setUserID(rs.getInt("UserID"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return supervisor;
	}

	// get all supervisors
	public static List<Supervisor> getAllSupervisors() {
		List<Supervisor> supervisors = new ArrayList<Supervisor>();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT * FROM supervisor ORDER BY SupID";
			stmt = con.createStatement();

			// 4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// retrieve from database
				Supervisor supervisor = new Supervisor();
				supervisor.setSupID(rs.getInt("SupID"));
				supervisor.setSupName(rs.getString("SupName"));
				supervisor.setSupPhoneNum(rs.getString("SupPhoneNum"));
				supervisor.setSupFaculty(rs.getString("SupFaculty"));
				supervisor.setSupTelegram(rs.getString("supTelegram"));
				supervisor.setUserID(rs.getInt("userID"));

				// store in list
				supervisors.add(supervisor);
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return supervisors;
	}

	// update supervisor
	public void updateSupervisor(Supervisor bean) {

		// get the supervisor
		SupID = bean.getSupID();
		SupName = bean.getSupName();
		SupPhoneNum = bean.getSupPhoneNum();
		SupFaculty = bean.getSupFaculty();
		SupImage = bean.getSupImage();
		AdminID = bean.getAdminID();
		UserID = bean.getUserID();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "UPDATE supervisor SET SupID=?, SupName=?,SupPhoneNum=?, SupFaculty=?, SupImage=?, AdminID=? WHERE UserID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupID);
			ps.setString(2, SupName);
			ps.setString(3, SupPhoneNum);
			ps.setString(4, SupFaculty);
			ps.setBlob(5, SupImage);
			ps.setInt(6, AdminID);
			ps.setInt(7, UserID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data updated succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// delete supervisor
	public void deleteSupervisor(int SupID) {

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "DELETE FROM supervisor WHERE SupID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data deleted succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	// update supervisor
			public void updateSupervisorByUserId(Supervisor bean) {

				// get the supervisor
				SupID = bean.getSupID();
				SupImage = bean.getSupImage();
				SupName = bean.getSupName();
				SupFaculty = bean.getSupFaculty();
				SupPhoneNum = bean.getSupPhoneNum();
				SupTelegram = bean.getSupTelegram();
				UserID = bean.getUserID();

				try {
					// call getConnection() method from ConnectionManager class
					con = ConnectionManager.getConnection();

					// 3. create statement
					String sql = "UPDATE supervisor SET supid=?,supname=?,supphonenum=?,supfaculty=?,suptelegram=?,supimage=? WHERE userid=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, SupID);
					ps.setString(2, SupName);
					ps.setString(3, SupPhoneNum);
					ps.setString(4, SupFaculty);
					ps.setString(5, SupTelegram);
					ps.setBlob(6, SupImage);
					ps.setInt(7, UserID);
					

					// 4. execute query
					ps.executeUpdate();
					System.out.println("Data updated succesfully");

					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			
			// update supervisor
						public void updateSupervisorByUserIdWithoutImage(Supervisor bean) {

							// get the supervisor
							SupID = bean.getSupID();
							SupName = bean.getSupName();
							SupFaculty = bean.getSupFaculty();
							SupPhoneNum = bean.getSupPhoneNum();
							SupTelegram = bean.getSupTelegram();
							UserID = bean.getUserID();

							try {
								// call getConnection() method from ConnectionManager class
								con = ConnectionManager.getConnection();

								// 3. create statement
								String sql = "UPDATE supervisor SET supid=?,supname=?,supphonenum=?,supfaculty=?,suptelegram=? WHERE userid=?";
								ps = con.prepareStatement(sql);
								ps.setInt(1, SupID);
								ps.setString(2, SupName);
								ps.setString(3, SupPhoneNum);
								ps.setString(4, SupFaculty);
								ps.setString(5, SupTelegram);
								ps.setInt(6, UserID);
								

								// 4. execute query
								ps.executeUpdate();
								System.out.println("Data updated succesfully");

								// 5. close connection
								con.close();

							} catch (Exception e) {
								e.printStackTrace();

							}
						}
	
	// get supervisor by userid
			public static Supervisor getSupervisorByUserId(int userid) {
				Supervisor supervisor = new Supervisor();

				try {
					// call getConnection() method from ConnectionManager class
					con = ConnectionManager.getConnection();

					// 3. create statement
					String sql = "SELECT * FROM supervisor WHERE userid=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, userid);

					// 4. execute query
					rs = ps.executeQuery();
					if (rs.next()) {
						supervisor.setSupID(rs.getInt("supid"));
						supervisor.setSupName(rs.getString("supname"));
						supervisor.setSupPhoneNum(rs.getString("supphonenum"));
						supervisor.setSupFaculty(rs.getString("supfaculty"));
						supervisor.setSupTelegram(rs.getString("suptelegram"));
						supervisor.setUserID(rs.getInt("userid"));
					}

					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

				return supervisor;
			}

	// get image
	public byte[] getImageFromID(int SupID) {
		byte[] imgData = null;
		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT SupImage FROM supervisor WHERE SupID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				blob = rs.getBlob("SupImage");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1000000];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				imgData = outputStream.toByteArray();
				inputStream.close();
				outputStream.close();
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return imgData;
	}
}
