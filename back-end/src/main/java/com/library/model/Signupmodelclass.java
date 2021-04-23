package com.library.model;

public class Signupmodelclass {

	private String studentName;
	private String rollNumber;
	private String password;
	private String department;
	private String email;
	private String mobile;
	private String rank;
	private String role;
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Signupmodelclass [studentName=" + studentName + ", rollNumber=" + rollNumber + ", password=" + password
				+ ", department=" + department + ", email=" + email + ", mobile=" + mobile + ", rank=" + rank
				+ ", role=" + role + "]";
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	
}
