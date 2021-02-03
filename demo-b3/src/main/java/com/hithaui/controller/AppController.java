package com.hithaui.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.entities.Person;

@RestController
@RequestMapping("/api")
public class AppController {

	@GetMapping("/")
	public ResponseEntity<?> home() {
		Person person = new Person("Trung", "Ha Noi");
		return ResponseEntity.status(201).body(person);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> homeasdasd() {
		Person person = new Person("abc", "xyz");
		return ResponseEntity.status(200).body(person);
	}
}
