package com.educandoweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.Payment;
import com.educandoweb.course.entities.pk.OrderItemPK;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> { 
	// herda os métodos do JPARepository 
	// meso sendo uma interface, não precisa ser implemnetado em uma classe
}
