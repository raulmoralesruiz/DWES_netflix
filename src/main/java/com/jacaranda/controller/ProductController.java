package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Product;
import com.jacaranda.service.ProductService;

@RestController
@RequestMapping(path = "/netflix")
public class ProductController {
		
	@Autowired
	private ProductService productService;

	
	// ----- GET -----
	
	/**
	 * GET. Método para revisar el listado de productos existentes.
	 * @return
	 */
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		return productService.getProducts();
	}
	
	
	/**
	 * GET. Método para buscar un producto indicando id.
	 * 
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable Long id){
		return ResponseEntity.ok(productService.getOneProductById(id));
	}

	
	/**
	 * GET. Método para revisar el listado de productos para suscipción BASIC.
	 * 
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/products/basic/")
	public ResponseEntity<?> getBasicProducts(){
		return productService.getBasicProducts();
	}
	
	
	/**
	 * GET. Método para revisar el listado de productos para suscipción PREMIUM.
	 * 
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/products/premium/")
	public ResponseEntity<?> getPremiumProducts(){
		return productService.getPremiumProducts();
	}

	
	
	// ----- POST -----

	/**
	 * POST. Creación de película, proporcionando JSON en body
	 * @param nuevoProducto
	 * @return
	 */
	@PostMapping("/products/")
	public Product createProduct(@RequestBody Product nuevoProducto) {
		return productService.createProduct(nuevoProducto);
	}
	
	
	
	// ----- PUT -----

	/** <---- CREAR MÉTODO PUT ----> */
	
	
	
	// ----- DELETE -----

	/**
	 * DELETE. Eliminación de producto, indicando id
	 * 
	 * @param id
	 * @return void
	 */
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}


