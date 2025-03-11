package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> { 
	// herda os métodos do JPARepository 
	// meso sendo uma interface, não precisa ser implemnetado em uma classe
}
