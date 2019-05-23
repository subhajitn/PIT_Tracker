package com.tcs.PIT;

import java.io.Serializable;
import javax.persistence.Embeddable;
 
@Embeddable
public class PIT_Faculty_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer pit_id;
	private Integer faculty_id;
	
	public PIT_Faculty_Details_PK() {
		
	}
	
	public PIT_Faculty_Details_PK(Integer pit_id, Integer faculty_id) {
		super();
		this.pit_id = pit_id;
		this.faculty_id = faculty_id;
	}
	
	public Integer getPit_id() {
		return pit_id;
	}
	public void setPit_id(Integer pit_id) {
		this.pit_id = pit_id;
	}
	public Integer getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}
	
	
}
