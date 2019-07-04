package com.tcs.PIT.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.PIT.model.Employee_details;
import com.tcs.PIT.model.Ievolve_Course_Details;
import com.tcs.PIT.model.PIT_Details;
import com.tcs.PIT.model.PIT_Faculty_Details;
import com.tcs.PIT.model.PIT_Participants_Details;
import com.tcs.PIT.model.PitCreationRequest;
import com.tcs.PIT.model.PitCreationResponse;
import com.tcs.PIT.repository.EmployeeRepository;
import com.tcs.PIT.repository.FacultyRepository;
import com.tcs.PIT.repository.ParticipantRepository;
import com.tcs.PIT.repository.PitDetailsRepository;

@Component
public class PitService {
	@Autowired
	private FacultyRepository facultyRepo;
	@Autowired
	private ParticipantRepository participantRepo;
	@Autowired
	private PitDetailsRepository pitDetailsRepo;
	@Autowired
	private CourseService courseService;
	@Autowired
	private EmployeeService empService;	
	
	/* 
	 * Faculty related service methods
	 */
	public List<PIT_Faculty_Details> getAllFaculty() {
		return facultyRepo.findAll();
	}
	
	public List<PIT_Faculty_Details> getAllFacultyById(int faculty_id) {
		Employee_details faculty=new Employee_details();
		faculty.setEmployee_id(faculty_id);
		return facultyRepo.findByFaculty(faculty);		
	}
	
	public List<PIT_Faculty_Details> getAllFacultyByPitId(Long pit_id) {
		return facultyRepo.findAllByPit_id(pit_id);
	}
	
	public void submitPitFaculty(List<PIT_Faculty_Details> facultyDetails) {
		 facultyRepo.saveAll(facultyDetails);
	}
	
	public void submitOnePitFaculty(PIT_Faculty_Details facultyDetail) {
		facultyRepo.save(facultyDetail);
	}
	/*
	 * Participant related service methods
	 */
	public List<PIT_Participants_Details> getAllParticipants() {
		return participantRepo.findAll();
	}
	public List<PIT_Participants_Details> getAllParticipantsById(String participant_ids) {
		/*Employee_details participant=new Employee_details();
		participant.setEmployee_id(participant_id);*/
		return participantRepo.findByParticipant(participant_ids);
	}
	public List<PIT_Participants_Details> getAllParticipantByPitId(Long pit_id) {
		return participantRepo.findAllByPit_id(pit_id);
	}
	public List<PIT_Participants_Details> submitPitParticipants(List<PIT_Participants_Details> participantDetails) {
		return participantRepo.saveAll(participantDetails);
	}
	/*
	 * Pit core service methods
	 */
	public List<PIT_Details> getAllPitDetails() {
		List<PIT_Details> pitList= new ArrayList<PIT_Details>();
		try{
			pitList=pitDetailsRepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pitList;		
	}
	public PIT_Details getPitDetailsByPitId(Long pit_id){
		Optional<PIT_Details> pitDetails=pitDetailsRepo.findById(pit_id);
		return pitDetails.get();
	}
	public PIT_Details updatePitDetails(PIT_Details pit, long pit_id) {
		Optional<PIT_Details> pitForUpdate = pitDetailsRepo.findById(pit_id);
		if (!pitForUpdate.isPresent())				
			return null;
		pit.setPit_id(pit_id);		
		return pitDetailsRepo.save(pit);
		
	}
	public String deletePit(long pit_id) {
		try {
			pitDetailsRepo.deleteById(pit_id);
			return "Pit No. "+pit_id+" deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Could not delete PIT-"+pit_id+". Please check the verify the request or try again later";
	}
	public PIT_Details submitPit(PIT_Details pit) {
		return pitDetailsRepo.save(pit);
	}
	public PitCreationResponse createPitRecord(PitCreationRequest newPitData) {
		PitCreationResponse response=new PitCreationResponse();
		if(null!=newPitData) {
			if(null==newPitData.getCourseId()) {
				response.setResponseCode("-100");
				response.setResponseMessage("Course Id cannot be empty");
				return response;
			}else if(null!=newPitData.getCourseId() && null==courseService.findCourseById(newPitData.getCourseId())) {
				response.setResponseCode("-110");
				response.setResponseMessage("Course Id invalid");
				return response;
			}else if(null==newPitData.getTopic_name() || newPitData.getTopic_name().equalsIgnoreCase("")) {
				response.setResponseCode("-200");
				response.setResponseMessage("Topic name cannot be empty");
				return response;
			}else if(null==newPitData.getArea() || newPitData.getArea().equalsIgnoreCase("")) {
				response.setResponseCode("-300");
				response.setResponseMessage("Area cannot be empty");
				return response;
			}else if(null==newPitData.getTechnology() || newPitData.getTechnology().equalsIgnoreCase("")) {
				response.setResponseCode("-400");
				response.setResponseMessage("Technology cannot be empty");
				return response;
			}else if(null==newPitData.getFacultyList() || (null!=newPitData.getFacultyList() && newPitData.getFacultyList().size()==0)) {
				response.setResponseCode("-500");
				response.setResponseMessage("Faculty details missing in the request");
				return response;
			}else if(null==newPitData.getParticpantList() || (null!=newPitData.getParticpantList() && newPitData.getParticpantList().size()==0)) {
				response.setResponseCode("-600");
				response.setResponseMessage("Participant details missing in the request");
				return response;
			}else {
				for(PIT_Faculty_Details faculty:newPitData.getFacultyList()) {
					if(null!=faculty.getFaculty() && null!=faculty.getFaculty().getEmployee_id() && null==empService.findEmployeeById(faculty.getFaculty().getEmployee_id())) {
						response.setResponseCode("-510");
						response.setResponseMessage("Faculty id -"+faculty.getFaculty().getEmployee_id()+" is invalid");
						return response;
					}
				}
				for(PIT_Participants_Details participant:newPitData.getParticpantList()) {
					if(null!=participant.getParticipant() && !participant.getParticipant().equalsIgnoreCase("")) {
						if(participant.getParticipant().contains(",")) {
							List<String> participantIdList=Arrays.asList(participant.getParticipant().split(","));
							for(String participantId:participantIdList) {
								if(null==empService.findEmployeeById(Integer.parseInt(participantId))){
									response.setResponseCode("-610");
									response.setResponseMessage("Participant id -"+participantId+" is invalid");
									return response;
								}
							}
						}else {
							if(null==empService.findEmployeeById(Integer.parseInt(participant.getParticipant()))){
								response.setResponseCode("-610");
								response.setResponseMessage("Participant id -"+participant.getParticipant()+" is invalid");
								return response;
							}
						}
					}else {
						response.setResponseCode("-620");
						response.setResponseMessage("Participant details is invalid");
						return response;
					}
					if(null!=participant && (null==participant.getCompletion_status() || (null!=participant.getCompletion_status()&& participant.getCompletion_status().equalsIgnoreCase("")))){
						response.setResponseCode("-700");
						response.setResponseMessage("Participant Completion Status is invalid");
						return response;
					}
				}
				PIT_Details corePitData=new PIT_Details();
				Ievolve_Course_Details courseData=new Ievolve_Course_Details();
				List<PIT_Faculty_Details> facultyDetails=new ArrayList<PIT_Faculty_Details>();
				List<PIT_Participants_Details> participantDetails=new ArrayList<PIT_Participants_Details>();				
				try {
					courseData.setIevolveId(newPitData.getCourseId());
					corePitData.setCourse(courseData);
					corePitData.setTopic_name(newPitData.getTopic_name());
					corePitData.setArea(newPitData.getArea());
					corePitData.setTechnology(newPitData.getTechnology());
					corePitData=this.submitPit(corePitData);
					System.out.println("Pit Created::"+corePitData.getPit_id());					
					for(PIT_Faculty_Details faculty:newPitData.getFacultyList()) {
						faculty.getPit_faculty_details_id().setPit_id(corePitData.getPit_id());
						facultyDetails.add(faculty);
					}
					this.submitPitFaculty(facultyDetails);
					for(PIT_Participants_Details participant:newPitData.getParticpantList()) {
						participant.getPit_participants_details_id().setPit_id(corePitData.getPit_id());
						participantDetails.add(participant);
					}
					this.submitPitParticipants(participantDetails);
					response.setResponseCode("0");
					response.setPitId(corePitData.getPit_id());
					response.setResponseMessage("Pit successfully created");
					return response;
				}catch(Exception e) {
					response.setResponseCode("-50");
					response.setResponseMessage(e.getMessage());
					return response;
				}
				
			}
			
		}else {
			response.setResponseCode("-700");
			response.setResponseMessage("Invalid Request");
			return response;
		}
		
	}
}
