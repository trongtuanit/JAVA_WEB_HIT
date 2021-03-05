package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.Student;
import com.hithaui.dto.StudentDTO;
import com.hithaui.exceptions.DuplicateRecordException;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.StudentRepository;
import com.hithaui.utils.ConvertObject;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping
	public ResponseEntity<?> findAllStudents() {
		List<Student> list = studentRepository.findAll();
		if (list.size() == 0) {
			throw new NotFoundException("No content");
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable("studentId") Integer studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + studentId);
		}
		return ResponseEntity.status(HttpStatus.OK).body(student.get().getListSubjects());
	}

	@PostMapping
	public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
		Student oldStudent = studentRepository.findByPhone(studentDTO.getPhone());
		if (oldStudent != null) {
			throw new DuplicateRecordException("Duplicate record student");
		}
		Student student = ConvertObject.fromStudentDTOtoStudentDAO(studentDTO);
		Student newStudent = studentRepository.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}

	@PatchMapping("/{studentId}")
	public ResponseEntity<?> editStudentById(@PathVariable("studentId") Integer studentId,
			@RequestBody StudentDTO studentDTO) {
		Optional<Student> optional = studentRepository.findById(studentId);
		if (!optional.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + studentId);
		}

		Student student = optional.get();

		if (studentDTO.getFullName() != null) {
			student.setFullName(studentDTO.getFullName());
		}

		if (studentDTO.getPhone() != null) {
			student.setPhone(studentDTO.getPhone());
		}

		Student newStudent = studentRepository.save(student);
		return ResponseEntity.status(HttpStatus.OK).body(newStudent);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("studentId") Integer studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + studentId);
		}
		studentRepository.deleteById(studentId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
