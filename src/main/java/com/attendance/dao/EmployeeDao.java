package com.attendance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.DTO.EmployeeDTO;
import com.attendance.DTO.ManagarDTO;

@Repository
public interface EmployeeDao extends CrudRepository<EmployeeDTO, Integer> {
	
	public List<EmployeeDTO> findByManager(ManagarDTO m);
	
	public EmployeeDTO findByEmpname(String name);

}
