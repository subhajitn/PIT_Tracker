package com.tcs.PIT.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		
		//employee services
		@GetMapping("/getAllEmployees")
		public List<Employee_details> findAllEmployees(){
			return employeeRepo.findAll();
		}
		
		@PostMapping("/addEmployee")
		public Employee_details createEmployee(@RequestBody Employee_details employee) {
			return employeeRepo.save(employee);
		}
		
		//course services
		@GetMapping("/getAllCourses")
		public List<Ievolve_Course_Details> findAllCourses(){
			return courseRepo.findAll();
		}
		
		@PostMapping("/addCourse")
		public Ievolve_Course_Details createCourse(@RequestBody Ievolve_Course_Details course) {
			return courseRepo.save(course);
		}
		
		
		//faculty services
		@GetMapping("/allFaculty")
		public List<PIT_Faculty_Details> getAllFaculty() {
			return facultyRepo.findAll();
		}	
		@GetMapping("/allFaculty/{faculty_id}")
		public List<PIT_Faculty_Details> getAllFacultyById(@PathVariable("faculty_id") int faculty_id) {
			Employee_details faculty=new Employee_details();
			faculty.setEmployee_id(faculty_id);
			return facultyRepo.findByFaculty(faculty);
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
				
		//participant services
		@GetMapping("/allParticipants")
		public List<PIT_Participants_Details> getAllParticipants() {
			return participantRepo.findAll();
		}		
		@GetMapping("/allParticipants/{participant_id}")
		public List<PIT_Participants_Details> getAllParticipantsById(@PathVariable("participant_id") int participant_id) {
			Employee_details participant=new Employee_details();
			participant.setEmployee_id(participant_id);
			return participantRepo.findByParticipant(participant);
		}
		@GetMapping("/allParticipantByPitId/{pit_id}")
		public List<PIT_Participants_Details> getAllParticipantByPitId(@PathVariable("pit_id") Long pit_id) {
			return participantRepo.findAllByPit_id(pit_id);
		}
		@PostMapping("/submitPitParticipantDetails")
		public List<PIT_Participants_Details> submitPitParticipants(@RequestBody List<PIT_Participants_Details> participantDetails) {

			return participantRepo.saveAll(participantDetails);

		}
		
		
		//pit_details services
		@PostMapping("/submitPit")
		public PIT_Details submitPit(@RequestBody PIT_Details pit) {

			return pitDetailsRepo.save(pit);

		}		
		@PostMapping("/extendPit")
		public ResponseEntity<Object> extendPit(@RequestBody PIT_Details pit) {
			
			PIT_Details extendPit = pitDetailsRepo.save(pit);			
			
			String responseHeader="PIT_ID : "+extendPit.getPit_id();


			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(responseHeader).toUri();

			return ResponseEntity.created(location).build();

		}
		
		@GetMapping("/allPITs")
		public List<PIT_Details> getAllPitDetails() {
			return pitDetailsRepo.findAll();
		}	
		
		@GetMapping("/searchByPit/{pit_id}")
		public PIT_Details getPitDetailsByPitId(@PathVariable("pit_id") Long pit_id){
			Optional<PIT_Details> pitDetails=pitDetailsRepo.findById(pit_id);
			return pitDetails.get();
		}
		
		
}
