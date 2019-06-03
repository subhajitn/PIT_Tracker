package com.tcs.PIT.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PIT_Participants_Details {
	@EmbeddedId
	private PIT_Participants_Details_PK pit_participants_details_id;
	
	@ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "employee_id")
	private Employee_details participant;	
	
	private boolean completion_status;
	
	public PIT_Participants_Details_PK getPit_participants_details_id() {
		return pit_participants_details_id;
	}
	public void setPit_participants_details_id(PIT_Participants_Details_PK pit_participants_details_id) {
		this.pit_participants_details_id = pit_participants_details_id;
	}
	public Employee_details getParticipant() {
		return participant;
	}
	public void setParticipant(Employee_details participant) {
		this.participant = participant;
	}	
	
	public boolean isCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(boolean completion_status) {
		this.completion_status = completion_status;
	}
	
}
