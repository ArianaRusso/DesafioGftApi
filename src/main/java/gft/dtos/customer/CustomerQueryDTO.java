package gft.dtos.customer;

import gft.dtos.address.AddressDTO;

public class CustomerQueryDTO {
	
	private Long id;
	private String name;
	private String cpf;
	private String phonenumber;
	private String email;
	
	private String cep;
	
	private AddressDTO address;

	public CustomerQueryDTO() {
		
	}

	public CustomerQueryDTO(Long id) {
	
		this.id = id;
	}

	public CustomerQueryDTO(Long id, String name, String cpf, String phonenumber, String email, String cep, AddressDTO address) {
		
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phonenumber = phonenumber;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	
	

}
