package com.tcs.PIT;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class PIT_Details {

	@EmbeddedId
	private PIT_Details_PK pit_details_id;
	
	@Column(length=20)
	private Integer faculty_id;
	
	private Integer ievolve_id;
	
	@Column(length=100)
	private String topic_name;
	
	@Column(length=100)
	private String area;
	
	@Column(length=100)
	private String technology;
	
	@ManyToOne
    @JoinColumn(name = "employee_id")
	private Employee_details employee;
	
	public PIT_Details() {
		
	}
	
	public PIT_Details(PIT_Details_PK pit_details_id, Integer faculty_id, Integer ievolve_id, String topic_name,
			String area, String technology) {
		super();
		this.pit_details_id = pit_details_id;
		this.faculty_id = faculty_id;
		this.ievolve_id = ievolve_id;
		this.topic_name = topic_name;
		this.area = area;
		this.technology = technology;
	}
	
	public PIT_Details_PK getPit_details_id() {
		return pit_details_id;
	}
	public void setPit_details_id(PIT_Details_PK pit_details_id) {
		this.pit_details_id = pit_details_id;
	}
	
	public Integer getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}
	public Integer getIevolve_id() {
		return ievolve_id;
	}
	public void setIevolve_id(Integer ievolve_id) {
		this.ievolve_id = ievolve_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
}
