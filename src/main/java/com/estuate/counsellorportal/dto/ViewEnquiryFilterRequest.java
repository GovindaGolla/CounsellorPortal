package com.estuate.counsellorportal.dto;

public class ViewEnquiryFilterRequest {
	
	private String courseName;
	private String classMode;
	private String enqStatus;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassMode() {
		return classMode;
	}
	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}
	public String getEnqStatus() {
		return enqStatus;
	}
	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}
	public ViewEnquiryFilterRequest(String courseName, String classMode, String enqStatus) {
		super();
		this.courseName = courseName;
		this.classMode = classMode;
		this.enqStatus = enqStatus;
	}
	public ViewEnquiryFilterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
