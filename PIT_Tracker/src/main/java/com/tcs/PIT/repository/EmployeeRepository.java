package com.tcs.PIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.PIT.model.Employee_details;

public interface EmployeeRepository extends JpaRepository<Employee_details,Integer>{

}
