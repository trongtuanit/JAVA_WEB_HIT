package com.hithaui.dto;

public class StudentDTO {
	private String fullName;
	private String phone;

	public StudentDTO() {
	}

	public StudentDTO(String fullName, String phone) {
		super();
		this.fullName = fullName;
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
