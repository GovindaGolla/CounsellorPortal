package com.estuate.counsellorportal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enquiry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enq_id;
    
    private String student_name;
    private String student_phoneno;
    private String course_name;
    private String class_mode;
    private String enq_status;
    
    @CreationTimestamp
    @Column(name="created_date", updatable = false)
    private LocalDateTime created_date;
    
    @UpdateTimestamp
    @Column(name="updated_date", insertable = false)
    private LocalDateTime updated_date;
    
    @ManyToOne
    @JoinColumn(name = "counsellor_id", nullable = false) // This creates the foreign key column in the Enquiry table
    private Counsellor counsellor;
    
    public Integer getEnq_id() {
        return enq_id;
    }
    
    public void setEnq_id(Integer enq_id) {
        this.enq_id = enq_id;
    }
    
    public String getStudent_name() {
        return student_name;
    }
    
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    
    public String getStudent_phoneno() {
        return student_phoneno;
    }
    
    public void setStudent_phoneno(String student_phoneno) {
        this.student_phoneno = student_phoneno;
    }
    
    public String getCourse_name() {
        return course_name;
    }
    
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    
    public String getClass_mode() {
        return class_mode;
    }
    
    public void setClass_mode(String class_mode) {
        this.class_mode = class_mode;
    }
    
    public String getEnq_status() {
        return enq_status;
    }
    
    public void setEnq_status(String enq_status) {
        this.enq_status = enq_status;
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
    
    public Counsellor getCounsellor() {
        return counsellor;
    }
    
    public void setCounsellor(Counsellor counsellor) {
        this.counsellor = counsellor;
    }
    
    public Enquiry(Integer enq_id, String student_name, String student_phoneno, String course_name, String class_mode,
                   String enq_status, LocalDateTime created_date, LocalDateTime updated_date, Counsellor counsellor) {
        super();
        this.enq_id = enq_id;
        this.student_name = student_name;
        this.student_phoneno = student_phoneno;
        this.course_name = course_name;
        this.class_mode = class_mode;
        this.enq_status = enq_status;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.counsellor = counsellor;
    }
    
    public Enquiry() {
        super();
    }
}