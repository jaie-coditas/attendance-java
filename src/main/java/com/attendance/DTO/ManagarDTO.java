package com.attendance.DTO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class ManagarDTO {
	
	@Id
	private int mid;
	
	private String name;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy = "manager")
    private List<EmployeeDTO> employeelist=new ArrayList<>();

}
