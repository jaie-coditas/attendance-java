package com.attendance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.DTO.EmployeeDTO;
import com.attendance.DTO.ManagarDTO;

@Repository
public interface ManagerDao extends CrudRepository<ManagarDTO, Integer> {

	public ManagarDTO findByName(String name);
	
	//public List<EmployeeDTO> findByMid(int id);
}
