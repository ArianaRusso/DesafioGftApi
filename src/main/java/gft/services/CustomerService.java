package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Address;
import gft.entities.Customer;
import gft.exceptions.SQLIntegrityConstraintViolationException;
import gft.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository clientRepository) {
		this.customerRepository = clientRepository;
	}

	public Customer saveCustomer(Customer customer) throws Exception {
		
		Address addresscep = ServiceAddress.searchAddressFor(customer.getCep());
		
		if(addresscep.getLogradouro() != null) {
			customer.setAddress(addresscep );
	
		}else {
			throw new SQLIntegrityConstraintViolationException("Cep Invalido");
		}

		return customerRepository.save(customer);

	}

	public Page<Customer> listAllCustomer(Pageable pageable) {

		return customerRepository.findAll(pageable);

	}

	public Customer findCustomer(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

	}

	public Customer updateCustomer(Customer customer, Long id) {

		Customer originCustomer = this.findCustomer(id);

		customer.setId(originCustomer.getId());

		return customerRepository.save(customer);

	}

	public void deleteCustomer(Long id) {
		Customer originCustomer = this.findCustomer(id);

		customerRepository.delete(originCustomer);

	}


}
