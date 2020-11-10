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
	
	@Column(name = "`inicio`")		// no necesario
	private LocalDateTime inicio;
	
	@Column(name = "`fin`")			// no necesario
	private LocalDateTime fin;
	
	@OneToOne(targetEntity = Product.class)
	private Product producto;
	
	private Long idCustomer;
	
	
	
	public Visual() {
		super();
	}
//	public Visual(LocalDateTime inicio, 
//			LocalDateTime fin, Product producto) {
//		super();
//		this.inicio = inicio;
//		this.fin = fin;
//		this.producto = producto;
//	}
	
	
	public Visual(LocalDateTime inicio, LocalDateTime fin, Product producto, Long idCustomer) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.producto = producto;
		this.idCustomer = idCustomer;
	}

	
	
	
	public Long getIdVisual() {
		return idVisual;
	}
	public void setIdVisual(Long idVisual) {
		this.idVisual = idVisual;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	public Product getProducto() {
		return producto;
	}
	public void setProducto(Product producto) {
		this.producto = producto;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	
	
	
}
