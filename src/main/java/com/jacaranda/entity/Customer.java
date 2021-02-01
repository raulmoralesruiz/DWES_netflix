package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity(name = "Customer")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	private String name;
	private String surname;
	private String address;
	private String city;
	private String dni;
	
	@OneToOne(targetEntity = Subscription.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private Subscription subscription;

	@OneToMany(targetEntity = Visual.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Visual> visuals;

	@OneToMany
	@JoinColumn(name="customer_id", foreignKey = @ForeignKey(name="customer_id_fk"), nullable = true)
	@JsonIgnore
	private List<Document> documents;

	
	
	public Customer() {
	}
	
	public Customer(String username, String name, String surname, String address, String city, String dni, Subscription subscription) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.dni = dni;
		this.subscription = subscription;
		this.visuals = new ArrayList<Visual>();
	}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<Visual> getVisuals() {
		return visuals;
	}
	public void setVisuals(List<Visual> visuals) {
		this.visuals = visuals;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	
}