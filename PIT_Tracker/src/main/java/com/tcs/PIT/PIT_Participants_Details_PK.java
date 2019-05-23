package com.tcs.PIT;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Embeddable
public class PIT_Participants_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer pit_id;
		
	@ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "employee_id")
	private Employee_details participant;	
	
	public Integer getPit_id() {
		return pit_id;
	}
	public void setPit_id(Integer pit_id) {
		this.pit_id = pit_id;
	}
}
