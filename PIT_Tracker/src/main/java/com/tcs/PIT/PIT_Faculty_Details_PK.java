package com.tcs.PIT;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Embeddable
public class PIT_Faculty_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer pit_id;
		
	@ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "employee_id")
	private Employee_details faculty;
	
	public Integer getPit_id() {
		return pit_id;
	}
	public void setPit_id(Integer pit_id) {
		this.pit_id = pit_id;
	}


	public Employee_details getFaculty() {
		return faculty;
	}
	public void setFaculty(Employee_details faculty) {
		this.faculty = faculty;
	}	
}
