package fyp4u.model;

public class User {
	private int userid;
	private String email;
	private String password;
	private String role;
	private Student student;
	private Supervisor supervisor;
	private boolean valid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
