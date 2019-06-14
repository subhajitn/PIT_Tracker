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
import com.tcs.PIT.repository.CourseRepository;
import com.tcs.PIT.repository.EmployeeRepository;
import com.tcs.PIT.repository.FacultyRepository;
import com.tcs.PIT.repository.ParticipantRepository;
import com.tcs.PIT.repository.PitDetailsRepository;

@RestController
public class PITController {
	
		@Autowired
		private FacultyRepository facultyRepo;
		@Autowired
		private ParticipantRepository participantRepo;
		@Autowired
		private PitDetailsRepository pitDetailsRepo;
		@Autowired
		private EmployeeRepository employeeRepo;
		@Autowired
		private CourseRepository courseRepo;
		
		
		/*
		 * This section covers the RPC methods for employee_details
		 */
		@GetMapping("/getAllEmployees")
		public List<Employee_details> findAllEmployees(){
			return employeeRepo.findAll();
		}
		
		@PostMapping("/addEmployee")
		public Employee_details createEmployee(@RequestBody Employee_details employee) {
			return employeeRepo.save(employee);
		}
		
		@PostMapping("/addEmployees")
		public List<Employee_details> createEmployees(@RequestBody List<Employee_details> employees) {
			return employeeRepo.saveAll(employees);
		}
		
		@PutMapping("/updateEmployee/{id}")
		public Employee_details updateEmployee(@RequestBody Employee_details employee, @PathVariable int id) {

			Optional<Employee_details> newEmployee = employeeRepo.findById(id);

			if (!newEmployee.isPresent())				
				return null;

			employee.setEmployee_id(id);
			
			return employeeRepo.save(employee);

			
		}
		@DeleteMapping("/removeEmployee/{id}")
		public String deleteStudent(@PathVariable int id) {
			employeeRepo.deleteById(id);
			return "Employee "+id+" deleted successfully";
		}
		
		/*
		 * This section covers the RPC methods for course_details
		 */
		@GetMapping("/getAllCourses")
		public List<Ievolve_Course_Details> findAllCourses(){
			return courseRepo.findAll();
		}
		
		@PostMapping("/addCourse")
		public Ievolve_Course_Details createCourse(@RequestBody Ievolve_Course_Details course) {
			return courseRepo.save(course);
		}		
		
		/*
		 * This section covers the RPC methods for faculty details
		 */
		@GetMapping("/allFaculty")
		public List<PIT_Faculty_Details> getAllFaculty() {
			return facultyRepo.findAll();
		}	
		@GetMapping("/allFaculty/{faculty_id}")
		public List<PIT_Faculty_Details> getAllFacultyById(@PathVariable("faculty_id") int faculty_id) {
			Employee_details faculty=new Employee_details();
			faculty.setEmployee_id(faculty_id);
			return facultyRepo.findByFaculty(faculty);
			//return facultyRepo.findAllByFacultyId(faculty_id);
		}
		@GetMapping("/allFacultyByPitId/{pit_id}")
		public List<PIT_Faculty_Details> getAllFacultyByPitId(@PathVariable("pit_id") Long pit_id) {
			return facultyRepo.findAllByPit_id(pit_id);
		}
		
		@PostMapping("/submitPitFacultyDetails")
		public List<PIT_Faculty_Details> submitPitFaculty(@RequestBody List<PIT_Faculty_Details> facultyDetails) {

			return facultyRepo.saveAll(facultyDetails);

		}
		@PostMapping("/submitOnePitFacultyDetails")
		public PIT_Faculty_Details submitOnePitFaculty(@RequestBody PIT_Faculty_Details facultyDetail) {

			return facultyRepo.save(facultyDetail);

		}
				
		/*
		 * This section covers the RPC methods for particpant_details
		 */
		@GetMapping("/allParticipants")
		public List<PIT_Participants_Details> getAllParticipants() {
			return participantRepo.findAll();
		}		
		@GetMapping("/allParticipants/{participant_ids}")
		public List<PIT_Participants_Details> getAllParticipantsById(@PathVariable("participant_ids") String participant_ids) {
			/*Employee_details participant=new Employee_details();
			participant.setEmployee_id(participant_id);*/
			return participantRepo.findByParticipant(participant_ids);
		}
		@GetMapping("/allParticipantByPitId/{pit_id}")
		public List<PIT_Participants_Details> getAllParticipantByPitId(@PathVariable("pit_id") Long pit_id) {
			return participantRepo.findAllByPit_id(pit_id);
		}
		@PostMapping("/submitPitParticipantDetails")
		public List<PIT_Participants_Details> submitPitParticipants(@RequestBody List<PIT_Participants_Details> participantDetails) {

			return participantRepo.saveAll(participantDetails);

		}
		
		
		/*
		 * This section covers the RPC methods for pit_details
		 */
		@PostMapping("/submitPit")
		public PIT_Details submitPit(@RequestBody PIT_Details pit) {

			return pitDetailsRepo.save(pit);

		}				
		
		@GetMapping("/allPITs")
		public List<PIT_Details> getAllPitDetails() {
			List<PIT_Details> pitList= new ArrayList<PIT_Details>();
			try{
				pitList=pitDetailsRepo.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return pitList;
			
		}	
		
		@GetMapping("/searchByPit/{pit_id}")
		public PIT_Details getPitDetailsByPitId(@PathVariable("pit_id") Long pit_id){
			Optional<PIT_Details> pitDetails=pitDetailsRepo.findById(pit_id);
			return pitDetails.get();
		}
		
		@PutMapping("/updatePIT/{pit_id}")
		public PIT_Details updateStudent(@RequestBody PIT_Details pit, @PathVariable long pit_id) {

			Optional<PIT_Details> pitForUpdate = pitDetailsRepo.findById(pit_id);

			if (!pitForUpdate.isPresent())				
				return null;

			pit.setPit_id(pit_id);
			
			return pitDetailsRepo.save(pit);
			
		}
		@DeleteMapping("/deletePIT/{pit_id}")
		public String deletePit(@PathVariable long pit_id) {
			try {
				pitDetailsRepo.deleteById(pit_id);
				return "Pit No. "+pit_id+" deleted successfully";
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return "Could not delete PIT-"+pit_id+". Please check the verify the request or try again later";
		}
		
		
}
