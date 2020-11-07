package com.jacaranda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Customer;

@Repository(value = "customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * Método que busca los clientes por nombre y apellido
	 * @param name
	 * @param surname
	 * @return Customer
	 */
	public Customer findCustomerByNameAndSurname(String name, String surname);
	
	
	/**
	 * Método que busca los clientes por ciudad
	 * @param city
	 * @return List<Customer>
	 */ 
	public List<Customer> findCustomerByCity(String city);
	
	
	/**
	 * Método que busca los clientes y los ordena por DNI
	 * @return
	 */
	@Query(value = "select * from customer order by dni", nativeQuery = true)
	public List<Customer> findAllOrderedByDni();

}
