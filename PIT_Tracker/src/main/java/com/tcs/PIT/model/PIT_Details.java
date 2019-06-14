package com.tcs.PIT.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="PIT_DETAILS")
public class PIT_Details {

	/*@EmbeddedId
	private PIT_Details_PK pit_details_id;*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pit_generator")
	@SequenceGenerator(name="pit_generator", sequenceName = "PIT_SEQ", allocationSize=1)
	private Long pit_id;
	
	@Column(length=100)
	private String topic_name;
	
	@Column(length=100)
	private String area;
	
	@Column(length=100)
	private String technology;
	
	@ManyToOne
    @JoinColumn(name = "ievolve_id", referencedColumnName = "ievolveId")
	//@JsonIgnore
	private Ievolve_Course_Details course;	
	
	/*private Integer faculty_id;
	
	private Integer participant_id;*/
		
	
	public Long getPit_id() {
		return pit_id;
	}
	public void setPit_id(Long pit_id) {
		this.pit_id = pit_id;
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
	//@JsonIgnore
	public Ievolve_Course_Details getCourse() {
		return course;
	}
	//@JsonIgnore
	public void setCourse(Ievolve_Course_Details course) {
		this.course = course;
	}
	/*public Integer getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}
	public Integer getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(Integer participant_id) {
		this.participant_id = participant_id;
	}*/
}
