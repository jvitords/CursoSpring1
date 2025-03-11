package com.educandoweb.course.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;

@RestController // Indica que esta classe é um controlador REST, ou seja, ela responderá a requisições HTTP retornando JSON ou XML
@RequestMapping(value = "/users") // Define o caminho base para os endpoints desta classe, ou seja, todas as URLs começarão com "/users"
public class UserResource {
	
	@Autowired // faz a injeção e instancia um "UserService"
	private UserService userService;
	
	@GetMapping(value = "/findall") // Indica que este método responde a requisições HTTP do tipo GET e se encontra em "/users/findallusers".
	public ResponseEntity<List<User>> encontrarUsuarios() {
		List<User> listUser = userService.findAll();
		return ResponseEntity.ok().body(listUser);
	}
	
	@GetMapping(value = "/id{id}") // Indica que este método responde a requisições HTTP do tipo GET e se encontra em "/users/id+numeroDoId".
	public ResponseEntity<User> findById(@PathVariable Long id) { // a anotação recebe a variável do Id
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
}
