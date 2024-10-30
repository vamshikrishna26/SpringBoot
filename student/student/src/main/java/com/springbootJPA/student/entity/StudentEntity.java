package com.springbootJPA.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int studentId;
	private String studentFname;
	private String studentLname;
	private String phoneNumber;
	private String address;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFname() {
		return studentFname;
	}
	public void setStudentFname(String studentFname) {
		this.studentFname = studentFname;
	}
	public String getStudentLname() {
		return studentLname;
	}
	public void setStudentLname(String studentLname) {
		this.studentLname = studentLname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public StudentEntity(int studentId, String studentFname, String studentLname, String phoneNumber, String address) {
		super();
		this.studentId = studentId;
		this.studentFname = studentFname;
		this.studentLname = studentLname;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public StudentEntity() {
		super();
	}
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentFname=" + studentFname + ", studentLname="
				+ studentLname + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	

}
