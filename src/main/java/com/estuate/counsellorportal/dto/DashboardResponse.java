package com.estuate.counsellorportal.dto;

public class DashboardResponse {
	
	private Integer totalEnqs;
	private Integer openEnqs;
	private Integer enrolledEnqs;
	private Integer lostEnqs;
	
	
	public Integer getTotalEnqs() {
		return totalEnqs;
	}
	public void setTotalEnqs(Integer totalEnqs) {
		this.totalEnqs = totalEnqs;
	}
	public Integer getOpenEnqs() {
		return openEnqs;
	}
	public void setOpenEnqs(Integer openEnqs) {
		this.openEnqs = openEnqs;
	}
	public Integer getEnrolledEnqs() {
		return enrolledEnqs;
	}
	public void setEnrolledEnqs(Integer enrolledEnqs) {
		this.enrolledEnqs = enrolledEnqs;
	}
	public Integer getLostEnqs() {
		return lostEnqs;
	}
	public void setLostEnqs(Integer lostEnqs) {
		this.lostEnqs = lostEnqs;
	}
	
	
	public DashboardResponse(Integer totalEnqs, Integer openEnqs, Integer enrolledEnqs, Integer lostEnqs) {
		super();
		this.totalEnqs = totalEnqs;
		this.openEnqs = openEnqs;
		this.enrolledEnqs = enrolledEnqs;
		this.lostEnqs = lostEnqs;
	}
	public DashboardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
