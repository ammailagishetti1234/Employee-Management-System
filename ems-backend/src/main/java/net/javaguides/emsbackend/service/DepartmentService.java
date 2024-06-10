package net.javaguides.emsbackend.service;

import java.util.List;

import net.javaguides.emsbackend.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long departementId, DepartmentDto updatedDepartment);
	
	void deleteDepartment(Long departmentId);
	
}
