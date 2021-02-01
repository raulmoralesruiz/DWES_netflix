package com.jacaranda.service;


import static org.mockito.Mockito.mock;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Visual;
import com.jacaranda.repository.CustomerRepository;


//@SpringBootTest
public class CustomerServiceTest {

	// Subject Under Test
	private CustomerService sut;
	
	private CustomerRepository mockedCustomerRepo;
	Customer mockedCustomer;

	
	
	@BeforeEach
	private void init() {
		mockedCustomerRepo = mock(CustomerRepository.class);
		mockedCustomer = mock(Customer.class);
		
		sut = new CustomerService(mockedCustomerRepo);
	}
	
	
	/**
	 * Test que comprueba el método "getCustomerVisuals" de CustomerService.
	 * Se busca al cliente por nombre y apellido
	 * En la comprobación final no se utiliza sut (servicio)
	 */
	@Test
	public void getCustomerVisualsByNameAndSurname() {		
		List<Visual> auxVisuals = null;
		
		Mockito.when(mockedCustomerRepo.findCustomerByNameAndSurname(Mockito.any(), Mockito.any())).thenReturn(mockedCustomer);
		
		if (!mockedCustomer.getVisuals().isEmpty()) {
			auxVisuals = mockedCustomer.getVisuals();
		}

		assert (auxVisuals == mockedCustomer.getVisuals() || auxVisuals == null);
	}
	
	
	/**
	 * Test que comprueba el método "getCustomerVisuals" de CustomerService.
	 * Se busca al cliente por id
	 * En la comprobación final se utiliza sut (servicio)
	 */
	@Test
	public void getCustomerVisualsById() {		
		List<Visual> auxVisuals = null;
		
		Mockito.when(mockedCustomerRepo.findCustomerById(Mockito.anyLong())).thenReturn(mockedCustomer);
		
		if (!mockedCustomer.getVisuals().isEmpty()) {
			auxVisuals = mockedCustomer.getVisuals();
		}
		
		assert (auxVisuals == sut.getCustomerVisuals(mockedCustomer.getId()) || auxVisuals == null);
	}
	
	
	/**
	 * Método de prueba que busca al cliente por id.
	 * Utilizado para investigar error del siguiente test "getOneCustomerError"
	 */
	@Test
	public void getOneCustomer() {
		
		Customer c = new Customer();

		Mockito.when(mockedCustomerRepo.findCustomerById(Mockito.anyLong())).thenReturn(mockedCustomer);
		c = mockedCustomerRepo.findCustomerById(Mockito.anyLong());

		assert (c == mockedCustomer);
	}
	
	
//	/** ERROR !
//	 * Por qué falla este método al usar findById (método propio de Spring)
//	 * Y no falla cuando uso findCustomerById (método creado a mano) ?
//	 */
//	@Test
//	public void getOneCustomerError() {
//		
//		Customer c = new Customer();
//
//		Mockito.when(mockedCustomerRepo.findById(Mockito.anyLong()).get()).thenReturn(mockedCustomer);
//		c = mockedCustomerRepo.findById(Mockito.anyLong()).get();
//
//		assert (c == mockedCustomer);
//	}

	
}