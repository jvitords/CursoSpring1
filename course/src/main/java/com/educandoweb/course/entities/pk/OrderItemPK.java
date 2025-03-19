package com.educandoweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class OrderItemPK implements Serializable{ // essa class serve para juntar o product com order e usar na class OrderItem
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_order") // colocando nome pra chave estrangeira
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name = "id_product") // colocando nome pra chave estrangeira
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
	
	
}
