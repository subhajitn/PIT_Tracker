package com.tcs.PIT;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	
	@OneToOne
    @JoinColumn(name = "ievolve_id", referencedColumnName = "ievolveId")
	private Ievolve_Course_Details course;	
	
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
}
