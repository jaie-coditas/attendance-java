package com.attendance.DTO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="attendance")
public class AttendanceRecordDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addid;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private String in_time;
	
	private String out_time;
	
	private double duration;
	
	private String status;
	@ManyToOne(cascade= CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "empcode",nullable=false)
	private EmployeeDTO emp;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getAddid() {
		return addid;
	}
	public void setAddid(int addid) {
		this.addid = addid;
	}
	public EmployeeDTO getEmp() {
		return emp;
	}
	public void setEmp(EmployeeDTO emp) {
		this.emp = emp;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double d) {
		this.duration = d;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String s) {
		status = s;
	}


}
