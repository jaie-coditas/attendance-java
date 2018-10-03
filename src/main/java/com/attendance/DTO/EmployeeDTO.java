package com.attendance.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeDTO {
	
	private String dept;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empcode;
	private String empname;
	private String Shift;
	public String getShift() {
		return Shift;
	}
	public void setShift(String shift) {
		Shift = shift;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public ManagarDTO getManager() {
		return manager;
	}
	public void setManager(ManagarDTO manager) {
		this.manager = manager;
	}
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY, mappedBy = "emp")
    private List<AttendanceRecordDTO> attendancelist=new ArrayList<AttendanceRecordDTO>();
	
	@ManyToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "mid")
	private ManagarDTO manager;
}
