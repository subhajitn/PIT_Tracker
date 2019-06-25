package com.tcs.PIT.model;

import java.util.List;

public class PitCreationRequest {

	private Integer courseId;
	private String topic_name;
	private String area;
	private String technology;
	private List<PIT_Faculty_Details> facultyList;
	private List<PIT_Participants_Details> particpantList;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	public List<PIT_Faculty_Details> getFacultyList() {
		return facultyList;
	}
	public void setFacultyList(List<PIT_Faculty_Details> facultyList) {
		this.facultyList = facultyList;
	}
	public List<PIT_Participants_Details> getParticpantList() {
		return particpantList;
	}
	public void setParticpantList(List<PIT_Participants_Details> particpantList) {
		this.particpantList = particpantList;
	}
	@Override
	public String toString() {
		return "PitCreationRequest [courseId=" + courseId + ", topic_name=" + topic_name + ", area=" + area
				+ ", technology=" + technology + ", facultyList=" + facultyList + ", particpantList=" + particpantList
				+ "]";
	}
	
}
