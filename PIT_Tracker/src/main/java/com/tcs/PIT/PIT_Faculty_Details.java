package com.tcs.PIT;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PIT_Faculty_Details {
	@EmbeddedId
	private PIT_Faculty_Details_PK pit_faculty_details_id;
	
	public PIT_Faculty_Details() {
		
	}
	
	public PIT_Faculty_Details(PIT_Faculty_Details_PK pit_faculty_details_id) {
		super();
		this.pit_faculty_details_id = pit_faculty_details_id;
	}

	public PIT_Faculty_Details_PK getPit_faculty_details_id() {
		return pit_faculty_details_id;
	}

	public void setPit_faculty_details_id(PIT_Faculty_Details_PK pit_faculty_details_id) {
		this.pit_faculty_details_id = pit_faculty_details_id;
	}	
}
