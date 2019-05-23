package com.tcs.PIT;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 
@Embeddable
public class PIT_Details_PK implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer pit_id;
	@Column(length=20)
	private String start_time;
	@Column(length=20)
	private String end_time;
	
	public PIT_Details_PK(Integer pit_id, String start_time, String end_time) {
		super();
		this.pit_id = pit_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public Integer getPit_id() {
		return pit_id;
	}
	public void setPit_id(Integer pit_id) {
		this.pit_id = pit_id;
	}
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
}
