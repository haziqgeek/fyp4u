package fyp4u.model;

import java.io.InputStream;
import java.sql.Date;

public class Project {
	private int stuID;
	private int supID;
	private int projID;
	private String projTitle;
	private InputStream proposalAttachment;
	private InputStream projAttachment;
	private String status;
	private String projDescription;
	private Date submissionDate;
	private Date deadline;
	private int score;
	private Student student;
	
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
	public int getProjID() {
		return projID;
	}
	public void setProjID(int projID) {
		this.projID = projID;
	}
	public String getProjTitle() {
		return projTitle;
	}
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
	public InputStream getProposalAttachment() {
		return proposalAttachment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProjDescription() {
		return projDescription;
	}
	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public InputStream getProjAttachment() {
		return projAttachment;
	}
	public void setProjAttachment(InputStream projAttachment) {
		this.projAttachment = projAttachment;
	}
	public void setProposalAttachment(InputStream proposalAttachment) {
		this.proposalAttachment = proposalAttachment;
	}
	
	
}
