package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.Student;
import com.hithaui.dao.Subject;
import com.hithaui.dto.SubjectDTO;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.StudentRepository;
import com.hithaui.repositories.SubjectRepository;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class SubjectController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@GetMapping
	public ResponseEntity<?> findAllSubjects() {
		List<Subject> list = subjectRepository.findAll();
		if (list.size() == 0) {
			throw new NotFoundException("No content");
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@PostMapping
	public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
		Optional<Student> student = studentRepository.findById(subjectDTO.getStudentId());
		if (!student.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + subjectDTO.getStudentId());
		}
		Subject subject = new Subject();
		subject.setName(subjectDTO.getName());
		subject.setStudent(student.get());

		Subject newSubject = subjectRepository.save(subject);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSubject);
	}
}
