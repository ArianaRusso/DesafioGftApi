package gft.dtos.carPart;


public class CarPartRegistrationDTO {

	private String name;
	private String description;
	private Long idStoreSupplier;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdStoreSupplier() {
		return idStoreSupplier;
	}
	public void setIdStoreSupplier(Long idStoreSupplier) {
		this.idStoreSupplier = idStoreSupplier;
	}
	
	
}
