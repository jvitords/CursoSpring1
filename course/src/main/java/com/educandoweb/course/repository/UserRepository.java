package com.educandoweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { 
	// herda os métodos do JPARepository 
	// meso sendo uma interface, não precisa ser implemnetado em uma classe
}
