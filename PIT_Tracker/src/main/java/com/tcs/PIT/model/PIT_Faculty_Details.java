package com.tcs.PIT.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PIT_Faculty_Details{
	
	@EmbeddedId
	private PIT_Faculty_Details_PK pit_faculty_details_id;
	
	@ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "employee_id")
	private Employee_details faculty;	
	
	public PIT_Faculty_Details_PK getPit_faculty_details_id() {
		return pit_faculty_details_id;
	}

	public void setPit_faculty_details_id(PIT_Faculty_Details_PK pit_faculty_details_id) {
		this.pit_faculty_details_id = pit_faculty_details_id;
	}	
	
	public Employee_details getFaculty() {
		return faculty;
	}
	public void setFaculty(Employee_details faculty) {
		this.faculty = faculty;
	}
}
