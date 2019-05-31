package com.tcs.PIT.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Embeddable
public class PIT_Participants_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private long pit_id;
		
	@ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "employee_id")
	private Employee_details participant;	
	
	public long getPit_id() {
		return pit_id;
	}
	public void setPit_id(long pit_id) {
		this.pit_id = pit_id;
	}
	public Employee_details getParticipant() {
		return participant;
	}
	public void setParticipant(Employee_details participant) {
		this.participant = participant;
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
	    PIT_Participants_Details_PK other = (PIT_Participants_Details_PK) obj;
	    return Objects.equals(pit_id, other.getPit_id());
	}
}