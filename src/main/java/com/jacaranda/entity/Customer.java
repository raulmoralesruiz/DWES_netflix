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
	
	@OneToOne(targetEntity = Suscription.class)
	private Suscription suscription;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Visual> visuals;

	@OneToMany
	@JoinColumn(name="customer_id", foreignKey = @ForeignKey(name="customer_id_fk"), nullable = true)
	@JsonIgnore
	private List<Document> documents;

	
	
	public Customer() {
	}
	
	public Customer(String username, String name, String surname, String address, String city, String dni, Suscription suscription) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.dni = dni;
		this.suscription = suscription;
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
//	public SuscriptionEnum getTipoSuscripcion() {
//		return tipoSuscripcion;
//	}
//	public void setTipoSuscripcion(SuscriptionEnum tipoSuscripcion) {
//		this.tipoSuscripcion = tipoSuscripcion;
//	}
	public Suscription getSuscription() {
		return suscription;
	}
	public void setSuscription(Suscription suscription) {
		this.suscription = suscription;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	
	
	
	
	
//	public void addVisual(Visual v) {
//		visuals.add(v);
//	}
	
//	public int contadorVisuals() {
//		int cont = 0;
//
//		for (Visual v : visuals) {
//			if (v.getProducto().getIdProduct() >= 0) {
//				cont++;
//			}
//		}
//		return cont;
//	}

	
	
}




// OLD
//{
//    "name": "Alvaro",
//    "surname": "Rueda",
//    "birthdate": null,
//    "address": "Calle Falsa 123, Brenes",
//    "city": "Sevilla",
//    "dni": "987987987",
//    "country": "Spain",
//    "mobileNumber": "666555444",
//    "gender": "Masculino",
//    "tipoSuscripcion": "BASIC"
//}


//private LocalDate birthdate;
//private String country;
//private String mobileNumber;
//private String gender;

//public Customer(String name, String surname, String city, String dni, SuscriptionEnum tipoSuscripcion) {
//super();
//this.name = name;
//this.surname = surname;
//this.city = city;
//this.dni = dni;
//this.tipoSuscripcion = tipoSuscripcion;
//this.visuals = new ArrayList<Visual>();
//}

//public Customer(String name, String surname, LocalDate birthdate, String address, String city, String dni,
//	String country, String mobileNumber, String gender, SuscriptionEnum tipoSuscripcion) {
//super();
//this.name = name;
//this.surname = surname;
//this.birthdate = birthdate;
//this.address = address;
//this.city = city;
//this.dni = dni;
//this.country = country;
//this.mobileNumber = mobileNumber;
//this.gender = gender;
//this.tipoSuscripcion = tipoSuscripcion;
//this.visuals = new ArrayList<Visual>();
//}


//public LocalDate getBirthdate() {
//	return birthdate;
//}
//public void setBirthdate(LocalDate birthdate) {
//	this.birthdate = birthdate;
//}
//public String getCountry() {
//	return country;
//}
//public void setCountry(String country) {
//	this.country = country;
//}
//public String getMobileNumber() {
//	return mobileNumber;
//}
//public void setMobileNumber(String mobileNumber) {
//	this.mobileNumber = mobileNumber;
//}
//public String getGender() {
//	return gender;
//}
//public void setGender(String gender) {
//	this.gender = gender;
//}
