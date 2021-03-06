package com.hithaui.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "exam_results")
public class ExamResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_result_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "student_subjects_id")
	private StudentSubject studentSubject;

	@Column(name = "mark", nullable = false)
	private Double mark;

	@Column(name = "re_mark")
	private Double reMark;

	@CreationTimestamp
	private Timestamp createAt;

	@UpdateTimestamp
	private Timestamp updateAt;

	public ExamResult() {
	}

	public ExamResult(Integer id, StudentSubject studentSubject, Double mark, Double reMark, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.id = id;
		this.studentSubject = studentSubject;
		this.mark = mark;
		this.reMark = reMark;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentSubject getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(StudentSubject studentSubject) {
		this.studentSubject = studentSubject;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Double getReMark() {
		return reMark;
	}

	public void setReMark(Double reMark) {
		this.reMark = reMark;
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
