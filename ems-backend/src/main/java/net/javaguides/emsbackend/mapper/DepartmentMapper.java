package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.entity.Department;

public class DepartmentMapper {

	//convert depart jpa to depat dto
	
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
		);
	}
	
	//conevrt departdto into departjpaentity
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
			);
	}
}
