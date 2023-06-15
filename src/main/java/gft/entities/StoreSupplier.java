package gft.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_store_supplier")
public class StoreSupplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cnpj;

	private String name;

	private String phonenumber;

	private String email;
	
	private String cep;

	@Embedded
	private Address address;

	public StoreSupplier() {

	}

	public StoreSupplier(Long id) {

		this.id = id;
	}

	public StoreSupplier(Long id, String cnpj, String name, String phonenumber, String email, String cep, Address address) {

		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
