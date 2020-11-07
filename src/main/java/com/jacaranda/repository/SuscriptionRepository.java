package com.jacaranda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Suscription;


@Repository(value = "suscriptionRepository")
public interface SuscriptionRepository extends CrudRepository<Suscription, Long> {

}
