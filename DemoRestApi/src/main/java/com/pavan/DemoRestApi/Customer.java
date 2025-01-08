package com.pavan.DemoRestApi;

import javax.xml.bind.annotation.XmlRootElement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@XmlRootElement
public class Customer {
	@Id
	private int cid;
	private String cName;
	private String designation;
	private double salary;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
