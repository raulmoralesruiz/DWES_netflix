package com.jacaranda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Product;

@Repository(value = "productRepository")
public interface ProductRepository extends CrudRepository<Product, Long> {

	/**
	 * Método que busca los productos disponibles con suscripción de tipo BASIC
	 * @return List<Product>
	 */
	@Query(value = "select * from product where tipo_suscripcion = 0", nativeQuery = true)
	public List<Product> findBasicProducts();
	
	
	/**
	 * Método que busca los productos disponibles con suscripción de tipo PREMIM
	 * @return List<Product>
	 */
	@Query(value = "select * from product where tipo_suscripcion = 1", nativeQuery = true)
	public List<Product> findPremiumProducts();

}
