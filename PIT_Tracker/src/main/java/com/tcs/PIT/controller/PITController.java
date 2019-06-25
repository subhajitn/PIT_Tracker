package com.tcs.PIT.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcs.PIT.model.Employee_details;
import com.tcs.PIT.model.Ievolve_Course_Details;
import com.tcs.PIT.model.PIT_Details;
import com.tcs.PIT.model.PIT_Details_PK;
import com.tcs.PIT.model.PIT_Faculty_Details;
import com.tcs.PIT.model.PIT_Faculty_Details_PK;
import com.tcs.PIT.model.PIT_Participants_Details;
import com.tcs.PIT.model.PIT_Participants_Details_PK;
import com.tcs.PIT.model.PitCreationRequest;
import com.tcs.PIT.model.PitCreationResponse;
import com.tcs.PIT.repository.CourseRepository;
import com.tcs.PIT.repository.EmployeeRepository;
import com.tcs.PIT.repository.FacultyRepository;
import com.tcs.PIT.repository.ParticipantRepository;
import com.tcs.PIT.repository.PitDetailsRepository;
import com.tcs.PIT.service.CourseService;
import com.tcs.PIT.service.EmployeeService;
import com.tcs.PIT.service.PitService;

@RestController
public class PITController {
	
		@Autowired
		private PitService pitService;
		@Autowired
		private EmployeeService empService;
		@Autowired
		private CourseService courseService;
		
		/*
		 * This section covers the RPC methods for employee_details
		 */
		@GetMapping("/PitTracker/getAllEmployees")
		public List<Employee_details> retrieveAllEmployeeDetails(){
			return empService.findAllEmployees();
		}
		
		@PostMapping("/PitTracker/addEmployee")
		public Employee_details createEmployee(@RequestBody Employee_details employee) {
			return empService.createEmployee(employee);
		}
		
		@PostMapping("/PitTracker/addEmployees")
		public List<Employee_details> createEmployeesInBulk(@RequestBody List<Employee_details> employees) {
			return empService.createEmployees(employees);
		}
		
		@PutMapping("/PitTracker/updateEmployee/{id}")
		public Employee_details updateEmployee(@RequestBody Employee_details employee, @PathVariable int id) {
			return empService.updateEmployee(employee,id);			
		}
		
		@DeleteMapping("/PitTracker/removeEmployee/{id}")
		public String deleteEmployee(@PathVariable int id) {			
			return empService.deleteEmployee(id);
		}
		
		/*
		 * This section covers the RPC methods for course_details
		 */
		@GetMapping("/PitTracker/getAllCourses")
		public List<Ievolve_Course_Details> retrieveCourseDetails(){
			return courseService.findAllCourses();
		}
		
		@PostMapping("/PitTracker/addCourse")
		public Ievolve_Course_Details createCourse(@RequestBody Ievolve_Course_Details course) {
			return courseService.createCourse(course);
		}		
		
		/*
		 * This section covers the RPC methods for faculty details
		 */
		@GetMapping("/PitTracker/allFaculty")
		public List<PIT_Faculty_Details> retrieveFacultyDetails() {
			return pitService.getAllFaculty();
		}	
		@GetMapping("/PitTracker/allFaculty/{faculty_id}")
		public List<PIT_Faculty_Details> getAllFacultyById(@PathVariable("faculty_id") int faculty_id) {
			return pitService.getAllFacultyById(faculty_id);
		}
		@GetMapping("/PitTracker/allFacultyByPitId/{pit_id}")
		public List<PIT_Faculty_Details> getAllFacultyByPitId(@PathVariable("pit_id") Long pit_id) {
			return pitService.getAllFacultyByPitId(pit_id);
		}
				
		/*
		 * This section covers the RPC methods for particpant_details
		 */
		@GetMapping("/PitTracker/allParticipants")
		public List<PIT_Participants_Details> retrieveParticipantDetails() {
			return pitService.getAllParticipants();
		}		
		@GetMapping("/PitTracker/allParticipants/{participant_ids}")
		public List<PIT_Participants_Details> getAllParticipantsById(@PathVariable("participant_ids") String participant_ids) {
			return pitService.getAllParticipantsById(participant_ids);
		}
		@GetMapping("/PitTracker/allParticipantByPitId/{pit_id}")
		public List<PIT_Participants_Details> getAllParticipantByPitId(@PathVariable("pit_id") Long pit_id) {
			return pitService.getAllParticipantByPitId(pit_id);
		}
		
		
		/*
		 * This section covers the RPC methods for pit_details
		 */
		@PostMapping("/PitTracker/submitPit")
		public PitCreationResponse submitPit(@RequestBody PitCreationRequest pit) {
			return pitService.createPitRecord(pit);
		}				
		
		@GetMapping("/PitTracker/allPITs")
		public List<PIT_Details> getAllPitDetails() {
			return pitService.getAllPitDetails();
			
		}	
		
		@GetMapping("/PitTracker/searchByPit/{pit_id}")
		public PIT_Details getPitDetailsByPitId(@PathVariable("pit_id") Long pit_id){
			return pitService.getPitDetailsByPitId(pit_id);
		}
		
		@PutMapping("/PitTracker/updatePIT/{pit_id}")
		public PIT_Details updateStudent(@RequestBody PIT_Details pit, @PathVariable long pit_id) {
			return pitService.updatePitDetails(pit, pit_id);			
		}
		@DeleteMapping("/PitTracker/deletePIT/{pit_id}")
		public String deletePit(@PathVariable long pit_id) {
			return pitService.deletePit(pit_id);
		}
		
		
}
