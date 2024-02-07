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
import fyp4u.model.Student;

public class StudentDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	byte[] buffer = new byte[4096];
	static Blob blob;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	String StuName, StuPhoneNum, StuCourse, StuFaculty, StuTelegram;
	private int StuID, UserID, stuSemester;
	static InputStream StuImage;

	// add student
	public void addStudent(Student bean) {

		// get the student
		StuID = bean.getStuID();
		StuName = bean.getStuName();
		StuPhoneNum = bean.getStuPhoneNum();
		StuCourse = bean.getStuCourse();
		StuFaculty = bean.getStuFaculty();
		StuImage = bean.getStuImage();
		stuSemester = bean.getStuSemester();
		StuTelegram = bean.getStuTelegram();
		UserID = bean.getUserID();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "INSERT INTO student(StuID, StuName, StuPhoneNum, StuCourse, StuFaculty, StuImage, StuSemester, StuTelegram)VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);
			ps.setString(2, StuName);
			ps.setString(3, StuPhoneNum);
			ps.setString(4, StuCourse);
			ps.setString(5, StuFaculty);
			ps.setBlob(6, StuImage);
			ps.setInt(7, stuSemester);
			ps.setString(8, StuTelegram);
			ps.setInt(9, UserID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data inserted succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get student by id
	public static Student getStudentById(int StuID) {
		Student student = new Student();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT * FROM student WHERE StuID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				student.setStuID(rs.getInt("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setStuPhoneNum(rs.getString("stuphonenum"));
				student.setStuSemester(rs.getInt("stusemester"));
				student.setStuCourse(rs.getString("stucourse"));
				student.setStuFaculty(rs.getString("stufaculty"));
				student.setStuTelegram(rs.getString("stutelegram"));
				student.setUserID(rs.getInt("userid"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return student;
	}

	// get all students
	public static List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT StuID, StuName, StuPhoneNum, StuCourse, StuFaculty, StuTelegram, UserID, StuSemester FROM student ORDER BY StuID";
			stmt = con.createStatement();

			// 4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// retrieve from database
				Student student = new Student();
				student.setStuID(rs.getInt("StuID"));
				student.setStuName(rs.getString("StuName"));
				student.setStuPhoneNum(rs.getString("StuPhoneNum"));
				student.setStuCourse(rs.getString("StuCourse"));
				student.setStuFaculty(rs.getString("StuFaculty"));
				student.setStuTelegram(rs.getString("StuTelegram"));
				student.setUserID(rs.getInt("userID"));
				student.setStuSemester(rs.getInt("stuSemester"));

				// store in list
				students.add(student);
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return students;
	}

	// update students
	public void updateStudent(Student bean) {

		// get the student
		StuID = bean.getStuID();
		StuName = bean.getStuName();
		StuPhoneNum = bean.getStuPhoneNum();
		StuCourse = bean.getStuCourse();
		StuFaculty = bean.getStuFaculty();
		UserID = bean.getUserID();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "UPDATE student SET StuID=?, StuName=?,StuPhoneNum=?,StuCourse=?, StuFaculty=?, StuSemester=?, StuTelegram=?  WHERE UserID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);
			ps.setString(2, StuName);
			ps.setString(3, StuPhoneNum);
			ps.setString(4, StuCourse);
			ps.setString(5, StuFaculty);
			ps.setInt(6, stuSemester);
			ps.setString(7, StuTelegram);
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

	// delete student
	public void deleteStudent(int StuID) {

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "DELETE FROM student WHERE StuID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data deleted succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get student by userid
	public static Student getStudentByUserId(int userid) {
		Student student = new Student();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT * FROM student WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, userid);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				student.setStuID(rs.getInt("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setStuPhoneNum(rs.getString("stuphonenum"));
				student.setStuSemester(rs.getInt("stusemester"));
				student.setStuCourse(rs.getString("stucourse"));
				student.setStuFaculty(rs.getString("stufaculty"));
				student.setStuTelegram(rs.getString("stutelegram"));
				student.setUserID(rs.getInt("userid"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return student;
	}

	// update student
	public void updateStudentByUserId(Student bean) {

		// get the student
		StuID = bean.getStuID();
		StuImage = bean.getStuImage();
		StuName = bean.getStuName();
		StuPhoneNum = bean.getStuPhoneNum();
		stuSemester = bean.getStuSemester();
		StuCourse = bean.getStuCourse();
		StuFaculty = bean.getStuFaculty();
		StuTelegram = bean.getStuTelegram();
		UserID = bean.getUserID();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "UPDATE student SET stuid=?,stuname=?,stuphonenum=?,stusemester=?,stucourse=?,stufaculty=?,stutelegram=?,stuimage=ifnull(?,stuimage) WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);
			ps.setString(2, StuName);
			ps.setString(3, StuPhoneNum);
			ps.setInt(4, stuSemester);
			ps.setString(5, StuCourse);
			ps.setString(6, StuFaculty);
			ps.setString(7, StuTelegram);
			ps.setBlob(8, StuImage);
			ps.setInt(9, UserID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data updated succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// update student
	public void updateStudentByUserIdWithoutImage(Student bean) {

		// get the student
		StuID = bean.getStuID();
		StuName = bean.getStuName();
		StuPhoneNum = bean.getStuPhoneNum();
		stuSemester = bean.getStuSemester();
		StuCourse = bean.getStuCourse();
		StuFaculty = bean.getStuFaculty();
		StuTelegram = bean.getStuTelegram();
		UserID = bean.getUserID();

		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "UPDATE student SET stuid=?,stuname=?,stuphonenum=?,stusemester=?,stucourse=?,stufaculty=?,stutelegram=? WHERE userid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);
			ps.setString(2, StuName);
			ps.setString(3, StuPhoneNum);
			ps.setInt(4, stuSemester);
			ps.setString(5, StuCourse);
			ps.setString(6, StuFaculty);
			ps.setString(7, StuTelegram);
			ps.setInt(8, UserID);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Data updated succesfully");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get image
	public byte[] getImageFromID(int StuID) {
		byte[] imgData = null;
		try {
			// call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();

			// 3. create statement
			String sql = "SELECT StuImage FROM student WHERE StuID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, StuID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				blob = rs.getBlob("StuImage");
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
