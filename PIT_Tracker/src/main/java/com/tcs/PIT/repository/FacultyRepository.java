package com.tcs.PIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.PIT.model.Employee_details;
import com.tcs.PIT.model.PIT_Faculty_Details;
import com.tcs.PIT.model.PIT_Faculty_Details_PK;

public interface FacultyRepository extends JpaRepository<PIT_Faculty_Details, PIT_Faculty_Details_PK>{
	
	@Query("SELECT u FROM PIT_Faculty_Details u WHERE u.pit_faculty_details_id.pit_id = :pit_id")
	List<PIT_Faculty_Details> findAllByPit_id(@Param("pit_id") Long pit_id);	
	
	List<PIT_Faculty_Details> findByFaculty(Employee_details faculty);
	
	/*@Query(value ="SELECT * FROM PIT_Faculty_Details u WHERE u.faculty.employee_id = :faculty_id",nativeQuery=true)
	List<PIT_Faculty_Details> findAllByFacultyId(@Param("faculty_id") int faculty_id);*/
}
