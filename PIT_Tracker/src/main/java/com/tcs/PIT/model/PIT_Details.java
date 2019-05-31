package com.tcs.PIT.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class PIT_Details {

	@EmbeddedId
	private PIT_Details_PK pit_details_id;
	
	@Column(length=100)
	private String topic_name;
	
	@Column(length=100)
	private String area;
	
	@Column(length=100)
	private String technology;
	
	@ManyToOne
    @JoinColumn(name = "ievolve_id", referencedColumnName = "ievolveId")
	private Ievolve_Course_Details course;	
	
	/*private Integer faculty_id;
	
	private Integer participant_id;*/
	
	public PIT_Details_PK getPit_details_id() {
		return pit_details_id;
	}
	public void setPit_details_id(PIT_Details_PK pit_details_id) {
		this.pit_details_id = pit_details_id;
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
	public Ievolve_Course_Details getCourse() {
		return course;
	}
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
