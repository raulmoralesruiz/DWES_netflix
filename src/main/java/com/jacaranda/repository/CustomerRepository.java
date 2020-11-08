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
	 * @return List<Customer>
	 */
	@Query(value = "select * from customer order by dni", nativeQuery = true)
	public List<Customer> findAllOrderedByDni();
	
	
	/**
	 * Método que muestra el username de cada cliente, ordenado alfabéticamente
	 * @return List<String>
	 */
	@Query(value = "select username from customer order by username", nativeQuery = true)
	public List<String> findCustomersByUsername();

	
	/** PENDIENTE - Query parametrizada */
//	/**
//	 * Método que muestra el id de cliente, pasando el username como parametro
//	 * @return List<Customer>
//	 */
//	@Query(value = "select id from customer where username = 'name'", nativeQuery = true)
//	public List<String> getCustomersByIdAndUsername();
////	SELECT id from customer where username = 'raulmr'
	
		
}
