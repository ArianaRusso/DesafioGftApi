package gft.dtos.customer;

import gft.dtos.address.AddressMapper;
import gft.entities.Customer;

public class CustomerMapper {
	
	public static Customer fromDTO(CustomerRegistrationDTO dto) {
		return new Customer(null,dto.getName(), dto.getCpf(),  dto.getPhonenumber(), dto.getEmail(),dto.getCep(),
				AddressMapper.fromDTO(dto.getAddress()));
	}
	
	public static CustomerQueryDTO fromEntity(Customer customer) {
		return new CustomerQueryDTO(customer.getId(),customer.getName(), customer.getCpf(), 
				customer.getPhonenumber(), customer.getEmail(), customer.getCep(),AddressMapper.fromEntity(customer.getAddress()));
	}
	
	public static CustomerQueryDTO fromEntityId(Customer customer) {
		return new CustomerQueryDTO(customer.getId());
	}

}
