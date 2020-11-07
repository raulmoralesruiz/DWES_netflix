package com.jacaranda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jacaranda.entity.Product;
import com.jacaranda.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	
	// ----- GET -----
	
	/**
	 * GET. Método para revisar el listado de productos existentes.
	 * 
	 * @return ResponseEntity
	 */
	public ResponseEntity<?> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}
	
	
	/**
	 * GET. Método para buscar un producto, indicando id.
	 * 
	 * @param idProduct
	 * @return Product
	 */
	public Product getOneProductById(Long idProduct) {		
		return productRepository.findById(idProduct).get();
	}
	
	
	/**
	 * GET. Método para revisar el listado de productos para suscipción BASIC.
	 * 
	 * @return ResponseEntity<?>
	 */
	public ResponseEntity<?> getBasicProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findBasicProducts());
	}
	
	
	/**
	 * GET. Método para revisar el listado de productos para suscipción PREMIUM.
	 * 
	 * @return ResponseEntity<?>
	 */
	public ResponseEntity<?> getPremiumProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findPremiumProducts());
	}

	
	
	// ----- POST -----

	/**
	 * POST. Creación de producto, proporcionando JSON en body
	 * 
	 * @param nuevoProducto
	 * @return Product
	 */
	public Product createProduct(@RequestBody Product nuevoProducto) {
		return productRepository.save(nuevoProducto);
	}
	
	
	// ----- DELETE -----

	/**
	 * DELETE. Eliminación de producto, proporcionando JSON en body
	 * 
	 * @param nuevoProducto
	 */
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	
	
}
