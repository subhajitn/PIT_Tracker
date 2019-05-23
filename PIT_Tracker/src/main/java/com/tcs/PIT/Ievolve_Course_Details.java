package com.tcs.PIT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IEVOLVE_COURSE_DETAILS")
public class Ievolve_Course_Details {
	@Id
	private Integer ievolveId;
	@Column(length=100)
	private String ievolve_course_name;
	@Column(length=20)
	private String delivery_subtype;
	private Integer offering_id;
	@Column(length=20)
	private String type;
	public Integer getIevolveId() {
		return ievolveId;
	}
	public void setIevolveId(Integer ievolveId) {
		this.ievolveId = ievolveId;
	}
	public String getIevolve_course_name() {
		return ievolve_course_name;
	}
	public void setIevolve_course_name(String ievolve_course_name) {
		this.ievolve_course_name = ievolve_course_name;
	}
	public String getDelivery_subtype() {
		return delivery_subtype;
	}
	public void setDelivery_subtype(String delivery_subtype) {
		this.delivery_subtype = delivery_subtype;
	}
	public Integer getOffering_id() {
		return offering_id;
	}
	public void setOffering_id(Integer offering_id) {
		this.offering_id = offering_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
