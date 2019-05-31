package com.tcs.PIT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TD_SPOC_DETAILS")
public class TD_Spoc_Details {
	@Id
	private Integer employeeId;
	@Column(nullable = false,length = 100)
	private String employeeName;
	private Integer telephoneNo;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(Integer telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
}
