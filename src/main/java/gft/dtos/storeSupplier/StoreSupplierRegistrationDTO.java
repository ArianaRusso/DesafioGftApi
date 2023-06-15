package gft.dtos.storeSupplier;

import gft.dtos.address.AddressDTO;

public class StoreSupplierRegistrationDTO {

	private String cnpj;

	private String name;

	private String phonenumber;

	private String email;
	
	private String cep;
	
	private AddressDTO address;
	
	

	public StoreSupplierRegistrationDTO() {
		
	}



	public StoreSupplierRegistrationDTO(String cnpj, String name, String phonenumber, String email, String cep, AddressDTO address) {
		
		this.cnpj = cnpj;
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.cep = cep;
		this.address = address;
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
