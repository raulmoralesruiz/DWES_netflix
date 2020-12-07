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
	private Category category;
	private ContentType contentType;
	private SubscriptionEnum subscriptionType;  

	public Product() {
		super();
	}
	public Product(SubscriptionEnum subscriptionType) {
		this();
		this.subscriptionType = subscriptionType;
	}
	public Product(String title, Category category, 
			ContentType contentType,
			SubscriptionEnum subscriptionType) {
		super();
		this.title = title;
		this.category = category;
		this.contentType = contentType;
		this.subscriptionType = subscriptionType;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ContentType getContentType() {
		return contentType;
	}
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	public SubscriptionEnum getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(SubscriptionEnum subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	
	
}
