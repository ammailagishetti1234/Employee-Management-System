package net.javaguides.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.entity.Department;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.exception.ResourceNotFound;
import net.javaguides.emsbackend.mapper.EmployeeMapper;
import net.javaguides.emsbackend.repository.DepartmentRepository;
import net.javaguides.emsbackend.repository.EmployeeRepository;
import net.javaguides.emsbackend.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	private DepartmentRepository departmentRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
	

	 @Override
	    public EmployeeDto createEmployee(EmployeeDto employeeDto) throws ResourceNotFound {
	        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
	        		.orElseThrow(() -> new ResourceNotFound("Department not exist with id: " + employeeDto.getDepartmentId()));
	        
	        
	        // Set the department for the employee
	        employee.setDepartment(department);
	        
	        Employee savedEmployee = employeeRepository.save(employee);
	        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	    }
    
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
    	Employee employee = employeeRepository.findById(employeeId)
    	 .orElseThrow(() -> 
    	       new ResourceNotFound("Employee is not exist with given id: " +employeeId));
    	return EmployeeMapper.mapToEmployeeDto(employee);
    }


	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFound("Employee not exist " + employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		  Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
	        		.orElseThrow(() -> new ResourceNotFound("Department not exist with id: " + updatedEmployee.getDepartmentId()));
	        
	        
	        // Set the department for the employee
	        employee.setDepartment(department);
	        
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}


	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
		    	 .orElseThrow(() -> 
		    	       new ResourceNotFound("Employee is not exist with given id: " +employeeId));
		
		employeeRepository.deleteById(employeeId);		
	}
    
    
}
