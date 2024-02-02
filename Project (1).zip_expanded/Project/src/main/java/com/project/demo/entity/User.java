package com.project.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String fname;
private String lname;
private String mob;
private String city;
private String pass;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String fname, String lname, String mob, String city, String pass) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.mob = mob;
	this.city = city;
	this.pass = pass;
}
public User(int id, String fname, String lname, String mob, String city, String pass) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.mob = mob;
	this.city = city;
	this.pass = pass;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", mob=" + mob + ", city=" + city + ", pass="
			+ pass + "]";
}

}
