package fyp4u.model;

import java.io.InputStream;

public class Student {
	private int stuID;
	private InputStream stuImage;
	private String stuName;
	private String stuPhoneNum;
	private String stuCourse;
	private String stuFaculty;
	private int userID;
	private int stuSemester;
	private String stuTelegram;
	
	public int getStuSemester() {
		return stuSemester;
	}
	public void setStuSemester(int stuSemester) {
		this.stuSemester = stuSemester;
	}
	public String getStuTelegram() {
		return stuTelegram;
	}
	public void setStuTelegram(String stuTelegram) {
		this.stuTelegram = stuTelegram;
	}
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public InputStream getStuImage() {
		return stuImage;
	}
	public void setStuImage(InputStream stuImage) {
		this.stuImage = stuImage;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPhoneNum() {
		return stuPhoneNum;
	}
	public void setStuPhoneNum(String stuPhoneNum) {
		this.stuPhoneNum = stuPhoneNum;
	}
	public String getStuCourse() {
		return stuCourse;
	}
	public void setStuCourse(String stuCourse) {
		this.stuCourse = stuCourse;
	}
	public String getStuFaculty() {
		return stuFaculty;
	}
	public void setStuFaculty(String stuFaculty) {
		this.stuFaculty = stuFaculty;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
