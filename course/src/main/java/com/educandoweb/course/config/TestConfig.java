package com.educandoweb.course.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;


@Configuration //Indica que esta classe é uma configuração do Spring Boot
@Profile("test") //Diz que essa configuração será carregada apenas quando o perfil "test" estiver ativo nas configurações do projeto
public class TestConfig implements CommandLineRunner {

	@Autowired 	// Injeta automaticamente o UserRepository, como se ele estivesse instanciando um objeto pra mim
	private UserRepository userRepository;
	
	@Override // O método run() será executado automaticamente após a inicialização da aplicação
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2)); // Salva os usuários no banco de dados utilizando o método do UseRepository
	}
}
