package com.educandoweb.course.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repository.UserRepository;
import com.educandoweb.course.service.exceptions.DataBaseException;
import com.educandoweb.course.service.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id)); // exception caso não seja encontrado
	}
	
	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		try {
			if(!userRepository.existsById(id)) {
				throw new ResourceNotFoundException(id); // exception caso não seja encontrado
			}
			userRepository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) { // exception caso não consiga excluir por integridade do BD
			throw new DataBaseException("Erro ao deletar user com ID: " + id);
		}
		
	}

	// encontrar o user com esse id e atualizar pelo user que foi passado no argumento
	public User updateUser(Long id, User obj) {
		try {
			User user = userRepository.getReferenceById(id);
			updateInfoUser(user, obj);
			return userRepository.save(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateInfoUser(User user, User newUser) {
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());
	}
}
