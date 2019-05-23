package com.tcs.PIT;

import java.io.Serializable;
import javax.persistence.Embeddable;
 
@Embeddable
public class PIT_Participants_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer pit_id;
	private Integer participant_id;
	
	public PIT_Participants_Details_PK(Integer pit_id, Integer participant_id) {
		super();
		this.pit_id = pit_id;
		this.participant_id = participant_id;
	}
	public Integer getPit_id() {
		return pit_id;
	}
	public void setPit_id(Integer pit_id) {
		this.pit_id = pit_id;
	}
	public Integer getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(Integer participant_id) {
		this.participant_id = participant_id;
	}
}
