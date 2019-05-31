package com.tcs.PIT.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Embeddable
public class PIT_Faculty_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private long pit_id;
		
	@ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "employee_id")
	private Employee_details faculty;
	
	public long getPit_id() {
		return pit_id;
	}
	public void setPit_id(long pit_id) {
		this.pit_id = pit_id;
	}


	public Employee_details getFaculty() {
		return faculty;
	}
	public void setFaculty(Employee_details faculty) {
		this.faculty = faculty;
	}	
	
	@Override
	public int hashCode() {
	        return Objects.hashCode(pit_id);
	}
	 
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	         return true;
	    if (obj == null)
	         return false;
	    if (getClass() != obj.getClass())
	         return false;
	    PIT_Faculty_Details_PK other = (PIT_Faculty_Details_PK) obj;
	    return Objects.equals(pit_id, other.getPit_id());
	}
}
