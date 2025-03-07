package com.educandoweb.course.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> encontrarUsuarios() {
		User user = new User(1L, "João Vitor", "joao@gmail.com", "993045596", "J.vitor10");
		return ResponseEntity.ok().body(user);
	}
}
