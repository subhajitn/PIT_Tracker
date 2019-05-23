package com.tcs.PIT;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PIT_Participants_Details {
	@EmbeddedId
	private PIT_Participants_Details_PK pit_participants_details_id;
	@Column(nullable = false,length = 100)
	private boolean completion_status;
	
	@ManyToOne
    @JoinColumn(name = "employee_id")
	private Employee_details participant;
	
	public PIT_Participants_Details() {
		
	}
	
	public PIT_Participants_Details(PIT_Participants_Details_PK pit_participants_details_id,
			boolean completion_status) {
		super();
		this.pit_participants_details_id = pit_participants_details_id;
		this.completion_status = completion_status;
	}
	
	public boolean isCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(boolean completion_status) {
		this.completion_status = completion_status;
	}
}
