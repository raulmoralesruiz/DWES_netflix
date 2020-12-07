package com.jacaranda.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Visual")
public class Visual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisual;
	
	@Column(name = "start")		// no necesario
	private LocalDateTime start;
	
	@Column(name = "end")			// no necesario
	private LocalDateTime end;
	
	@OneToOne(targetEntity = Product.class)
	private Product product;
	
	private Long idCustomer;
	
	
	
	public Visual() {
		super();
	}	
	public Visual(LocalDateTime start, LocalDateTime end, Product product, Long idCustomer) {
		super();
		this.start = start;
		this.end = end;
		this.product = product;
		this.idCustomer = idCustomer;
	}

	
	
	
	public Long getIdVisual() {
		return idVisual;
	}
	public void setIdVisual(Long idVisual) {
		this.idVisual = idVisual;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	
	
	
}
