package net.javaguides.emsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.service.DepartmentService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	//build add depart REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		
		return new ResponseEntity<>(department, HttpStatus.CREATED);
		
	}
	
	
	//build get depart API
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		
		return ResponseEntity.ok(departmentDto);
	}
	
	
	//build get all depat
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		List<DepartmentDto> departments = departmentService.getAllDepartments();
		
		return ResponseEntity.ok(departments);
	}
	
	
	//build update dept
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartment) {
		DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
		
		return ResponseEntity.ok(departmentDto);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		
		return ResponseEntity.ok("Department deleted succefully...");
	}
}
