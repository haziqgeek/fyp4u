package fyp4u.model;

import java.sql.Time;
import java.util.Date;

public class Consultation {
	private int stuID;
	private int supID;
	private int consultID;
	private Time consultTime;
	private Date consultDate;
	private String platform;
	private String description;
	private String status;
	private Student student;
	private Supervisor supervisor;
	
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public int getSupID() {
		return supID;
	}
	public void setSupID(int supID) {
		this.supID = supID;
	}
	public int getConsultID() {
		return consultID;
	}
	public void setConsultID(int consultID) {
		this.consultID = consultID;
	}
	public Time getConsultTime() {
		return consultTime;
	}
	public void setConsultTime(Time consultTime) {
		this.consultTime = consultTime;
	}
	public Date getConsultDate() {
		return consultDate;
	}
	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
}