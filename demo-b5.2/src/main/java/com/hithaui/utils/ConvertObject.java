package com.hithaui.utils;

import com.hithaui.dao.Student;
import com.hithaui.dto.StudentDTO;

public class ConvertObject {

	public static Student fromStudentDTOtoStudentDAO(StudentDTO studentDTO) {
		Student student = new Student();
		student.setFullName(studentDTO.getFullName());
		student.setPhone(studentDTO.getPhone());
		return student;
	}
}
