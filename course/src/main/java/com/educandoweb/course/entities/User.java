package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // estou dizendo que essa classe é uma tabela no BD 
@Table(name = "tb_user") // estou dizendo que o nome dessa tabela será tb_user
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@jakarta.persistence.Id // estou colocando a variável "id" como campo primário(PK) do BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // a PK terá autoincremento, adicionando automaticamente
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore // serve para não mostrar/ignorar a listas de orders abaixo
	@OneToMany(mappedBy = "client") // refere que a class User é um para muitos em relação a class order(um user tem varios order)
	// e o "mappedBy = "client"" significa que está fazendo referencia ao client("private User client" da class "Order")
	List<Order> orders = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
