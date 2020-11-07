package com.jacaranda.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Suscription")
public class Suscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSuscription;
	
	private LocalDateTime start;
	
	private LocalDateTime end;
	
	private SuscriptionEnum typeOfSuscription;
		
	private Long idCustomer;
	
	
	
	public Suscription() {
		super();
	}
	public Suscription(LocalDateTime start, LocalDateTime end, SuscriptionEnum typeOfSuscription, Long idCustomer) {
		super();
		this.start = start;
		this.end = end;
		this.typeOfSuscription = typeOfSuscription;
		this.idCustomer = idCustomer;
	}
	
	
	
	public Long getIdSuscription() {
		return idSuscription;
	}
	public void setIdSuscription(Long idSuscription) {
		this.idSuscription = idSuscription;
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
	public SuscriptionEnum getTypeOfSuscription() {
		return typeOfSuscription;
	}
	public void setTypeOfSuscription(SuscriptionEnum typeOfSuscription) {
		this.typeOfSuscription = typeOfSuscription;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	
	
}
