package com.tcs.PIT;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PIT_Participants_Details {
	@EmbeddedId
	private PIT_Participants_Details_PK pit_participants_details_id;
	private boolean completion_status;
	
	public boolean isCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(boolean completion_status) {
		this.completion_status = completion_status;
	}
}
