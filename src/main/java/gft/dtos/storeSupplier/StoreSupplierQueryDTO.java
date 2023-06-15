package gft.dtos.storeSupplier;

import gft.dtos.address.AddressDTO;

public class StoreSupplierQueryDTO {
	
	private Long id;
	
	private String cnpj;

	private String name;

	private String phoneNumber;

	private String email;
	
	private String cep;
	
	private AddressDTO address;

	public StoreSupplierQueryDTO() {
		
	}

	public StoreSupplierQueryDTO(Long id, String cnpj, String name, String phoneNumber, String email, String cep,
			AddressDTO address) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.cep = cep;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public AddressDTO getAddressDTO() {
		return address;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.address = addressDTO;
	}
	
	
	
	

}
