package com.jacaranda.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	private String title;
	private Category categoria;
	private TipoContenido tipoContenido;
	private SuscriptionEnum tipoSuscripcion;  

	public Product() {
		super();
	}
	public Product(SuscriptionEnum tipoSuscripcion) {
		this();
		this.tipoSuscripcion = tipoSuscripcion;
	}
	public Product(String title, Category categoria, 
			TipoContenido tipoContenido,
			SuscriptionEnum tipoSuscripcion) {
		super();
		this.title = title;
		this.categoria = categoria;
		this.tipoContenido = tipoContenido;
		this.tipoSuscripcion = tipoSuscripcion;
	}


	
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
//	public int getIdProduct() {
//		return idProduct;
//	}
//	public void setIdProduct(int idProduct) {
//		this.idProduct = idProduct;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategoria() {
		return categoria;
	}
	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}
	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	public SuscriptionEnum getTipoSuscripcion() {
		return tipoSuscripcion;
	}
	public void setTipoSuscripcion(SuscriptionEnum tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}
	
	
	
}
