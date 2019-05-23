package com.tcs.PIT;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_DETAILS")
public class Employee_details {
	@Id
	private Integer employee_id;
	@Column(length=10)
	private String mid;
	private String employee_name;
	private String email;
	private boolean activity_flag;
	private String branch_name;
	private String department;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<PIT_Details> pit_details;
	
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
	private List<PIT_Faculty_Details> pit_faculty_details;
	
	@OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
	private List<PIT_Participants_Details> pit_participants_details;
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActivity_flag() {
		return activity_flag;
	}
	public void setActivity_flag(boolean activity_flasg) {
		this.activity_flag = activity_flasg;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
