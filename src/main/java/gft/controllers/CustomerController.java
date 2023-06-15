package gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dtos.customer.CustomerMapper;
import gft.dtos.customer.CustomerQueryDTO;
import gft.dtos.customer.CustomerRegistrationDTO;
import gft.entities.Customer;
import gft.services.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<Page<CustomerQueryDTO>> searchAllCustomers(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(customerService.listAllCustomer(pageable).map(CustomerMapper::fromEntity));		
			
		
	}
	
	@PostMapping
	public ResponseEntity<CustomerQueryDTO> saveCustomer(@RequestBody CustomerRegistrationDTO dto)throws Exception{
		
		Customer customer = customerService.saveCustomer(CustomerMapper.fromDTO(dto));
		
		return ResponseEntity.ok(CustomerMapper.fromEntity(customer));
		
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<CustomerQueryDTO> searchCustomer(@PathVariable Long id){

		Customer customer = customerService.findCustomer(id);
		
		return ResponseEntity.ok(CustomerMapper.fromEntity(customer));
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CustomerQueryDTO> alterCustomer(@RequestBody CustomerRegistrationDTO dto,
			@PathVariable Long id){
		
		try {
		
			Customer customer = customerService.updateCustomer(CustomerMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(CustomerMapper.fromEntity(customer));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CustomerQueryDTO> deleteCustomer(@PathVariable Long id){
		
		try {
			customerService.deleteCustomer(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	

}
