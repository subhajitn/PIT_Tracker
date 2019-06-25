package com.tcs.PIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.PIT.model.Employee_details;
import com.tcs.PIT.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee_details> findAllEmployees(){
		return employeeRepo.findAll();
	}
	public Employee_details findEmployeeById(int id) {
		Optional<Employee_details> employee=employeeRepo.findById(id);
		if(!employee.isPresent()) {
			return null;
		}
		return employee.get();
	}
	
	public Employee_details createEmployee(Employee_details employee) {
		return employeeRepo.save(employee);
	}
	
	public List<Employee_details> createEmployees(List<Employee_details> employees) {
		return employeeRepo.saveAll(employees);
	}
	
	public Employee_details updateEmployee(Employee_details employee,int id) {
		Optional<Employee_details> newEmployee = employeeRepo.findById(id);
		if (!newEmployee.isPresent())				
			return null;
		employee.setEmployee_id(id);
		
		return employeeRepo.save(employee);
	}
	public String deleteEmployee(int id) {
		employeeRepo.deleteById(id);
		return "Employee "+id+" deleted successfully";
	}
}
