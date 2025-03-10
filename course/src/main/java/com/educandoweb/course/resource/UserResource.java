package com.educandoweb.course.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // Indica que esta classe é um controlador REST, ou seja, ela responderá a requisições HTTP retornando JSON ou XML
@RequestMapping(value = "/users") // Define o caminho base para os endpoints desta classe, ou seja, todas as URLs começarão com "/users"
public class UserResource {

	@GetMapping(value = "/findallusers") // Indica que este método responde a requisições HTTP do tipo GET em "/users/findallusers".
	public ResponseEntity<User> encontrarUsuarios() {

		// Cria um novo usuário fictício (substitua por lógica real para buscar do banco
		// de dados).
		User user = new User(1L, "João Vitor", "joao@gmail.com", "993045596", "J.vitor10");

		// Retorna uma resposta HTTP 200 (OK) contendo o usuário no corpo da resposta.
		return ResponseEntity.ok().body(user);
	}
}
