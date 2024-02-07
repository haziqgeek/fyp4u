package fyp4u.model;

import java.io.InputStream;
import java.sql.Blob;

public class Supervisor {
	private int supID;
	private InputStream supImage;
	private String supName;
	private String supPhoneNum;
	private String supFaculty;
	private int adminID;
	private int userID;
	private String supTelegram;
	
	public String getSupTelegram() {
		return supTelegram;
	}
	public void setSupTelegram(String supTelegram) {
		this.supTelegram = supTelegram;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int getSupID() {
		return supID;
	}
	public void setSupID(int supID) {
		this.supID = supID;
	}
	public InputStream getSupImage() {
		return supImage;
	}
	public void setSupImage(InputStream supImage) {
		this.supImage = supImage;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupPhoneNum() {
		return supPhoneNum;
	}
	public void setSupPhoneNum(String supPhoneNum) {
		this.supPhoneNum = supPhoneNum;
	}
	public String getSupFaculty() {
		return supFaculty;
	}
	public void setSupFaculty(String supFaculty) {
		this.supFaculty = supFaculty;
	}
	public int getAdminID() {
		return adminID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
