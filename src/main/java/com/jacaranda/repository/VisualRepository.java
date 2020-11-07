package com.jacaranda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Visual;

@Repository(value = "visualRepository")
public interface VisualRepository extends CrudRepository<Visual, Long> {

}
