package com.jacaranda.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubscription;
	
	private LocalDateTime start;
	
	private LocalDateTime end;
	
	private SubscriptionEnum subscriptionType;
		
	private Long idCustomer;
	
	
	
	public Subscription() {
		super();
	}
	public Subscription(LocalDateTime start, LocalDateTime end, SubscriptionEnum subscriptionType, Long idCustomer) {
		super();
		this.start = start;
		this.end = end;
		this.subscriptionType = subscriptionType;
		this.idCustomer = idCustomer;
	}
	
	
	
	public Long getIdSubscription() {
		return idSubscription;
	}
	public void setIdSubscription(Long idSubscription) {
		this.idSubscription = idSubscription;
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
	public SubscriptionEnum getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(SubscriptionEnum subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	
	
}
