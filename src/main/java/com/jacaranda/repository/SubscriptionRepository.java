package com.jacaranda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Subscription;


@Repository(value = "subscriptionRepository")
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

}
