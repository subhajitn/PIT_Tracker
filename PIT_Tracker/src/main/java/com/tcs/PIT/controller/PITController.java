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
import com.tcs.PIT.model.PIT_Details;
import com.tcs.PIT.model.PIT_Details_PK;
import com.tcs.PIT.model.PIT_Faculty_Details;
import com.tcs.PIT.model.PIT_Faculty_Details_PK;
import com.tcs.PIT.model.PIT_Participants_Details;
import com.tcs.PIT.model.PIT_Participants_Details_PK;
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
		
		
		//faculty services
		@GetMapping("/allFaculty")
		public List<PIT_Faculty_Details> getAllFaculty() {
			return facultyRepo.findAll();
		}	
		@GetMapping("/allFaculty/{pit_id}/{faculty_id}")
		public PIT_Faculty_Details getAllFacultyById(@PathVariable("pit_id") long pit_id,@PathVariable("faculty_id") int faculty_id) {
			PIT_Faculty_Details_PK pk=new PIT_Faculty_Details_PK();
			Employee_details faculty=new Employee_details();
			faculty.setEmployee_id(faculty_id);
			pk.setPit_id(pit_id);
			pk.setFaculty(faculty);
			Optional<PIT_Faculty_Details> facultyDetails=facultyRepo.findById(pk);
			return facultyDetails.get();
		}
		@GetMapping("/allFacultyByPitId/{pit_id}")
		public List<PIT_Faculty_Details> getAllFacultyByPitId(@PathVariable("pit_id") long pit_id) {
			return facultyRepo.findAllByPit_id(pit_id);
		}
				
		//participant services
		@GetMapping("/allParticipants")
		public List<PIT_Participants_Details> getAllParticipants() {
			return participantRepo.findAll();
		}		
		@GetMapping("/allParticipants/{pit_id}/{participant_id}")
		public PIT_Participants_Details getAllParticipantsById(@PathVariable("pit_id") long pit_id,@PathVariable("participant_id") int participant_id) {
			PIT_Participants_Details_PK pk=new PIT_Participants_Details_PK();
			Employee_details participant=new Employee_details();
			participant.setEmployee_id(participant_id);
			pk.setPit_id(pit_id);
			pk.setParticipant(participant);
			Optional<PIT_Participants_Details> participantDetails=participantRepo.findById(pk);
			return participantDetails.get();
		}
		@GetMapping("/allParticipantByPitId/{pit_id}")
		public List<PIT_Participants_Details> getAllParticipantByPitId(@PathVariable("pit_id") long pit_id) {
			return participantRepo.findAllByPit_id(pit_id);
		}
		
		
		//pit_details services
		@PostMapping("/submitPit")
		public ResponseEntity<Object> submitPit(@RequestBody PIT_Details pit) {
			long pit_id = 0;
			if(null!=pit && null!=pit.getPit_details_id()) {
				pit_id=pitDetailsRepo.getNextPitId();
				pit.getPit_details_id().setPit_id(pit_id);
			}
			PIT_Details newPit = pitDetailsRepo.save(pit);
			
			//inserting into faculty details
			/*PIT_Faculty_Details facultyDetails=new PIT_Faculty_Details();
			PIT_Faculty_Details_PK facultyPK =new PIT_Faculty_Details_PK();
			Employee_details faculty=new Employee_details();
			faculty.setEmployee_id(pit.getFaculty_id());
			facultyPK.setFaculty(faculty);
			facultyPK.setPit_id(pit_id);
			facultyDetails.setPit_faculty_details_id(facultyPK);
			PIT_Faculty_Details addFaculty=facultyRepo.save(facultyDetails);*/
			
			//inserting into participant details
			/*PIT_Participants_Details particpantDetails=new PIT_Participants_Details();
			PIT_Participants_Details_PK participantPK =new PIT_Participants_Details_PK();
			Employee_details participant=new Employee_details();
			participant.setEmployee_id(pit.getParticipant_id());
			participantPK.setParticipant(participant);
			participantPK.setPit_id(pit_id);
			particpantDetails.setPit_participants_details_id(participantPK);
			PIT_Participants_Details addParticpant=participantRepo.save(particpantDetails);*/
			
			String responseHeader="PIT_ID : "+newPit.getPit_details_id().getPit_id()/*+
								  "Faculty : "+addFaculty.getPit_faculty_details_id().getFaculty().getEmployee_id()+
								  "Participant : "+addParticpant.getPit_participants_details_id().getParticipant().getEmployee_id()*/;

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(responseHeader).toUri();

			return ResponseEntity.created(location).build();

		}		
		@PostMapping("/extendPit")
		public ResponseEntity<Object> extendPit(@RequestBody PIT_Details pit) {
			
			PIT_Details extendPit = pitDetailsRepo.save(pit);
			
			//inserting into faculty details
			/*PIT_Faculty_Details facultyDetails=new PIT_Faculty_Details();
			PIT_Faculty_Details_PK facultyPK =new PIT_Faculty_Details_PK();
			Employee_details faculty=new Employee_details();
			faculty.setEmployee_id(pit.getFaculty_id());
			facultyPK.setFaculty(faculty);
			facultyPK.setPit_id(pit.getPit_details_id().getPit_id());
			facultyDetails.setPit_faculty_details_id(facultyPK);
			PIT_Faculty_Details addFaculty=facultyRepo.save(facultyDetails);*/
			
			//inserting into participant details
			/*PIT_Participants_Details particpantDetails=new PIT_Participants_Details();
			PIT_Participants_Details_PK participantPK =new PIT_Participants_Details_PK();
			Employee_details participant=new Employee_details();
			participant.setEmployee_id(pit.getParticipant_id());
			participantPK.setParticipant(participant);
			participantPK.setPit_id(pit.getPit_details_id().getPit_id());
			particpantDetails.setPit_participants_details_id(participantPK);
			PIT_Participants_Details addParticpant=participantRepo.save(particpantDetails);*/
			
			String responseHeader="PIT_ID : "+extendPit.getPit_details_id().getPit_id()/*+
					  "Faculty : "+addFaculty.getPit_faculty_details_id().getFaculty().getEmployee_id()+
					  "Participant : "+addParticpant.getPit_participants_details_id().getParticipant().getEmployee_id()*/;


			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(responseHeader).toUri();

			return ResponseEntity.created(location).build();

		}
		
		@GetMapping("/allPITs")
		public List<PIT_Details> getAllPitDetails() {
			return pitDetailsRepo.findAll();
		}	
		
		@GetMapping("/searchByPit/{pit_id}")
		public List<PIT_Details> getPitDetailsByPitId(@PathVariable("pit_id") long pit_id){
			return pitDetailsRepo.findAllByPit_id(pit_id);
		}
		
		
}
