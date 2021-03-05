package com.hithaui.dto;

public class SubjectDTO {
	private String name;
	private Integer studentId;

	public SubjectDTO() {
	}

	public SubjectDTO(String name, Integer studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}
