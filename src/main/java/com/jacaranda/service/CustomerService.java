package com.jacaranda.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.entity.Product;
import com.jacaranda.entity.Suscription;
import com.jacaranda.entity.Visual;
import com.jacaranda.repository.CustomerRepository;
import com.jacaranda.repository.DocumentRepository;
import com.jacaranda.repository.ProductRepository;
import com.jacaranda.repository.SuscriptionRepository;
import com.jacaranda.repository.VisualRepository;


@Service
public class CustomerService extends AbstractServiceUtils implements IService<Customer> {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private VisualRepository visualRepo;
	
	@Autowired
	private SuscriptionRepository suscriptionRepo;

	
	@Autowired
	private DocumentRepository documentRepo;

	@Autowired
	private FileHandlerService fhService;
	
	
	// ---------------------------------------------- CUSTOMER ----------------------------------------------

	// ----- GET -----
	
	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepo.findAll());
	}
		
	
	public Customer getOneCustomerById(Long idCustomer) {		
		return customerRepo.findById(idCustomer).get();
	}
	
	
	public Customer getOneCustomerByNameAndSurname(String name, String surname) {		
		return customerRepo.findCustomerByNameAndSurname(name, surname);
	}
	
	
	public ResponseEntity<?> getCustomersByCity(String city) {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepo.findCustomerByCity(city));
	}
	
	
	public ResponseEntity<?> getCustomersByDni() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepo.findAllOrderedByDni());
	}
	
	
	public ResponseEntity<?> getCustomersByUsername() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepo.findCustomersByUsername());
	}
	
	
	/** PENDIENTE - Query parametrizada */
//	public ResponseEntity<?> getCustomersByIdAndUsername() {
//		return ResponseEntity.status(HttpStatus.OK).body(customerRepo.findCustomersByIdAndUsername());
//	}
	
	
	// ----- POST -----
	
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	
	
	// ----- PUT -----
	
	/** <---- CREAR MÉTODO PUT ----> */
	
	
	
	// ----- DELETE -----
	
	public void deleteCustomer(@PathVariable Long id){
		customerRepo.deleteById(id);
	}
	
	
	// ---------------------------------------------- CUSTOMER ----------------------------------------------

	
	
	
	// ------------------------------------------ CUSTOMER - VISUAL ------------------------------------------
	
	public ResponseEntity<?> getVisuals() {
		return ResponseEntity.status(HttpStatus.OK).body(visualRepo.findAll());
	}
	
	
	/**
	 * Método que obtiene las visualizaciones de un cliente
	 * 
	 * @param idCustomer
	 * @return List<Visual>
	 */
	public List<Visual> getCustomerVisuals(Long idCustomer) {
		
		List<Visual> auxVisuals = null;
		
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();

		// se comprueba si el cliente tiene visualizaciones.
		if (!auxCustomer.getVisuals().isEmpty()) {
			// se crea la lista con las visualizaciones del cliente
			auxVisuals = auxCustomer.getVisuals();
		}
		
		// se devuelve la lista
		return auxVisuals;
	}

	
	/**
	 * Método que inserta una visualización a un cliente
	 * 
	 * @param newVisual Visual
	 * @param idCustomer int
	 * @param idProduct int
	 * @return Customer
	 */
	public Customer addVisual(Visual newVisual, Long idCustomer, Long idProduct) {
		
		// se guarda el producto en una variable auxiliar
		Product auxProduct = productRepo.findById(idProduct).get();
		
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();
		
		
		// se inserta el producto auxiliar a la visualización
		newVisual.setProducto(auxProduct);
		
		// se inserta el id de cliente a la visualización
		newVisual.setIdCustomer(idCustomer);
		
		// se guarda la visualización en la BBDD
		visualRepo.save(newVisual);
		
		
		// se inserta la visualización al cliente
		auxCustomer.getVisuals().add(newVisual);
		
		// se guarda el cliente en la BBDD
		customerRepo.save(auxCustomer);
		
		return auxCustomer;
	}
	
	
	public void deleteVisual(Long idCustomer, Long idVisual) {
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();
		
		// se guarda la visualización en una variable auxiliar
		Visual auxVisual = visualRepo.findById(idVisual).get();

		// se elimina la visualización del cliente
		auxCustomer.getVisuals().remove(auxVisual);
		
		// se guarda el cliente en la BBDD
		customerRepo.save(auxCustomer);
	}
	
	// ------------------------------------------ CUSTOMER - VISUAL ------------------------------------------
	


	
	// ---------------------------------------- CUSTOMER - SUSCRIPTION ---------------------------------------

	// ----- GET -----

	/**
	 * Método que obtiene todas las suscripciones
	 * 
	 * @return ResponseEntity<?>
	 */
	public ResponseEntity<?> getSuscriptions() {
		return ResponseEntity.status(HttpStatus.OK).body(suscriptionRepo.findAll());
	}
	
	/**
	 * Método que obtiene la suscripción de un cliente
	 * 
	 * @param idCustomer
	 * @return Suscription
	 */
	public Suscription getCustomerSuscription(Long idCustomer) {
		
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();

		// se guarda la suscripción en una variable auxiliar
		Suscription auxSuscription = auxCustomer.getSuscription();
		
		// se devuelve la lista
		return auxSuscription;
	}
	
	
	
	// ----- POST -----
	
	/**
	 * Método que inserta una suscripción a un cliente
	 * 
	 * @param newSuscription
	 * @param idCustomer
	 * @return
	 */
	public Customer addSuscription(Suscription newSuscription, Long idCustomer) {
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();
		
		// Se comprueba si el cliente tiene alguna suscripción activa.
		if (auxCustomer.getSuscription() != null) {
			// se asigna el cliente a null, para devolverlo al final
			auxCustomer = null;
		} else {
			/** SUSCRIPTION */
			// se inserta el id de cliente a la suscripción
			newSuscription.setIdCustomer(idCustomer);
			
			// se guarda la suscripción en la BBDD
			suscriptionRepo.save(newSuscription);
			
			/** CUSTOMER */
			// se inserta la suscripción al cliente
			auxCustomer.setSuscription(newSuscription);
			
			// se guarda el cliente en la BBDD
			customerRepo.save(auxCustomer);
		}
		
		return auxCustomer;
	}
	
	
	
	// ----- PUT -----

	/** <---- CREAR MÉTODO PUT ----> */


	
	// ----- DELETE -----
	
	public void deleteSuscription(Long idCustomer) {
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();
		
		// se guarda la suscripción en una variable auxiliar
		Suscription auxSuscription = auxCustomer.getSuscription();

		// se elimina la suscripción del cliente
		auxCustomer.setSuscription(null);
		
		// se elimina la suscripción en la BBDD
		suscriptionRepo.delete(auxSuscription);
		
		// se guarda el cliente en la BBDD
		customerRepo.save(auxCustomer);
	}
	
	// ---------------------------------------- CUSTOMER - SUSCRIPTION ---------------------------------------

	
	// ------------------------------------------ CUSTOMER - DOCUMENT ----------------------------------------
	
	// ----- GET -----
	
	/**
	 * GET. Método que lee/visualiza un documento
	 * 
	 * @param idDoc
	 * @return
	 * @throws SQLException
	 */
	public ResponseEntity<Resource> viewDocument(Long idDoc) throws SQLException{
		Document document = documentRepo.findById(idDoc).get();
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getFile().getBytes(1, (int) document.getFile().length())));
	}
	
	
	/**
	 * GET. Método que obtiene los documentos de un cliente
	 * 
	 * @param idCustomer
	 * @return List<Document>
	 */
	public List<Document> getCustomerDocuments(Long idCustomer) {
		
		List<Document> newDocuments = null;
		
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepo.findById(idCustomer).get();

		// se comprueba si el cliente tiene documentos.
		if (!auxCustomer.getDocuments().isEmpty()) {			
			
			// se inicializa la lista
			newDocuments = new ArrayList<Document>();
			
			// se rellena la lista
			for (Document d : auxCustomer.getDocuments()) {
				newDocuments.add(new Document(d.getIdDocument(), d.getFileName(), d.getFileSize(), d.getFileType()));
			}
		}
		
		// se devuelve la lista
		return newDocuments;
	}


	
	// ----- PUT -----
	
	@Override
	public Customer addDocument(Long id, MultipartFile mpf) {
		Customer c = null;

		try {
			Document doc = documentRepo.save(new Document(
							fhService.createBlob(mpf), 
							mpf.getOriginalFilename(), 
							Integer.valueOf((int) mpf.getSize()),
							mpf.getContentType()));

			c = customerRepo.findById(id).get();
			c.setDocuments(c.getDocuments() != null && !c.getDocuments().isEmpty() ? c.getDocuments() : new ArrayList<>());
			c.getDocuments().add(doc);
			customerRepo.save(c);

		} catch (NumberFormatException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}

		return c;
	}
	
	// ------------------------------------------ CUSTOMER - DOCUMENT ----------------------------------------
	
	
}
