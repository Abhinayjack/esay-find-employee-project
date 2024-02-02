package com.project.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String fname;
private String lname;
private String mob;
private String address;
private String skill;
private int charge;


public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, String fname, String lname, String mob, String address, String skill, int charge) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.mob = mob;
	this.address = address;
	this.skill = skill;
	this.charge = charge;
}
public Employee(String fname, String lname, String mob, String address, String skill, int charge) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.mob = mob;
	this.address = address;
	this.skill = skill;
	this.charge = charge;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public int getCharge() {
	return charge;
}
public void setCharge(int charge) {
	this.charge = charge;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", mob=" + mob + ", address=" + address
			+ ", Skill=" + skill + ", charge=" + charge + "]";
}

}
