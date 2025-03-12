package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;


@Configuration //Indica que esta classe é uma configuração do Spring Boot
@Profile("test") //Diz que essa configuração será carregada apenas quando o perfil "test" estiver ativo nas configurações do projeto
public class TestConfig implements CommandLineRunner {

	@Autowired 	// Injeta automaticamente o UserRepository, como se ele estivesse instanciando um objeto pra mim
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override // O método run() será executado automaticamente após a inicialização da aplicação
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Computers");
		Category c2 = new Category(null, "Eletronics");
		Category c3 = new Category(null, "Books");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.ENVIADO, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.ENTREGUE, u1);
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuários no banco de dados utilizando o método do UseRepository
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
