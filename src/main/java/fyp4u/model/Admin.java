package fyp4u.model;

public class Admin {
	
	private int adminID;
	private String adminUsername;
	private String adminPhonenumber;
	private int userID;
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPhonenumber() {
		return adminPhonenumber;
	}
	public void setAdminPhonenumber(String adminPhonenumber) {
		this.adminPhonenumber = adminPhonenumber;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
