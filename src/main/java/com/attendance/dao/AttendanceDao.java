package com.attendance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.DTO.AttendanceRecordDTO;
import com.attendance.DTO.EmployeeDTO;

@Repository
public interface AttendanceDao extends CrudRepository< AttendanceRecordDTO, Integer> {

	public List<AttendanceRecordDTO> findByEmp(EmployeeDTO e);
}
