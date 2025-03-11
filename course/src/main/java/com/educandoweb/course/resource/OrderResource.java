package com.educandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.service.OrderService;

@RestController // Indica que esta classe é um controlador REST, ou seja, ela responderá a requisições HTTP retornando JSON ou XML
@RequestMapping(value = "/orders") // Define o caminho base para os endpoints desta classe, ou seja, todas as URLs começarão com "/Orders"
public class OrderResource {
	
	@Autowired // faz a injeção e instancia um "order"
	private OrderService order;
	
	@GetMapping(value = "/findall") // Indica que este método responde a requisições HTTP do tipo GET e se encontra em "/Orders/findallOrders".
	public ResponseEntity<List<Order>> encontrarUsuarios() {
		List<Order> listOrder = order.findAll();
		return ResponseEntity.ok().body(listOrder);
	}
	
	@GetMapping(value = "/id{id}") // Indica que este método responde a requisições HTTP do tipo GET e se encontra em "/Orders/id+numeroDoId".
	public ResponseEntity<Order> findById(@PathVariable Long id) { // a anotação recebe a variável do Id
		Order Order = order.findById(id);
		return ResponseEntity.ok().body(Order);
	}
	
}
