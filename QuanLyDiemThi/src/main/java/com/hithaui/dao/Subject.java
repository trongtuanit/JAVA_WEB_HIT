package com.hithaui.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Integer id;

	@Column(name = "subject_code", nullable = false, unique = true)
	private Integer subjectCode;

	@Nationalized
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentSubject> studentSubject;

	@CreationTimestamp
	private Timestamp createAt;

	@UpdateTimestamp
	private Timestamp updateAt;

	public Subject() {
	}

	public Subject(Integer id, Integer subjectCode, String name, List<StudentSubject> studentSubject,
			Timestamp createAt, Timestamp updateAt) {
		super();
		this.id = id;
		this.subjectCode = subjectCode;
		this.name = name;
		this.studentSubject = studentSubject;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(Integer subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentSubject> getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(List<StudentSubject> studentSubject) {
		this.studentSubject = studentSubject;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
}
