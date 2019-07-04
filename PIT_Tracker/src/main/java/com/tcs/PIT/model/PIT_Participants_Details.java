package com.tcs.PIT.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PIT_Participants_Details {
	@EmbeddedId
	private PIT_Participants_Details_PK pit_participants_details_id;
	
	/*@ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "employee_id")
	//@JsonIgnore
	private Employee_details participant;*/	
	
	@Column(length=2000)
	private String participant;	
	
	@Column(length=1)
	private String completion_status;
	
	public PIT_Participants_Details_PK getPit_participants_details_id() {
		return pit_participants_details_id;
	}
	public void setPit_participants_details_id(PIT_Participants_Details_PK pit_participants_details_id) {
		this.pit_participants_details_id = pit_participants_details_id;
	}
	//@JsonIgnore
	public String getParticipant() {
		return participant;
	}
	//@JsonIgnore
	public void setParticipant(String participant) {
		this.participant = participant;
	}	
	
	public String getCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}
	
}
