package com.tcs.PIT.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Embeddable
public class PIT_Faculty_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private long pit_id;
	
	@Column(length=20)
	private String start_time;
	
	@Column(length=20)
	private String end_time;	
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public long getPit_id() {
		return pit_id;
	}
	public void setPit_id(long pit_id) {
		this.pit_id = pit_id;
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
