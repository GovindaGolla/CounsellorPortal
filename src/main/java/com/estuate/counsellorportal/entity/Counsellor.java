package com.estuate.counsellorportal.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorid;
	private String name;
	@Column(unique = true)
	private String email;
	private String pwd;
	private String phoneno;
	@CreationTimestamp
	@Column(name="created_date", updatable = false)
	private LocalDateTime created_date;
	@UpdateTimestamp
	@Column(name="updated_date", insertable = false)
	private LocalDateTime updated_date;
	
	@OneToMany(mappedBy = "counsellor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enquiry> enquiries;

	public Integer getCounsellorid() {
		return counsellorid;
	}

	public void setCounsellorid(Integer counsellorid) {
		this.counsellorid = counsellorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public LocalDateTime getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}

	public List<Enquiry> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<Enquiry> enquiries) {
		this.enquiries = enquiries;
	}

	public Counsellor(Integer counsellorid, String name, String email, String pwd, String phoneno,
			LocalDateTime created_date, LocalDateTime updated_date, List<Enquiry> enquiries) {
		super();
		this.counsellorid = counsellorid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phoneno = phoneno;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.enquiries = enquiries;
	}

	public Counsellor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
