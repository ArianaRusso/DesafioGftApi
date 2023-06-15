package gft.dtos.carPart;

import gft.dtos.storeSupplier.StoreSupplierCarPartDTO;

public class CarPartQueryDTO {

	private Long id;
	private String name;
	private String description;
	
	private StoreSupplierCarPartDTO suplierDTO;

	public CarPartQueryDTO() {}
	public CarPartQueryDTO(Long id, String name, String description, StoreSupplierCarPartDTO suplierDTO) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.suplierDTO = suplierDTO;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public StoreSupplierCarPartDTO getSuplierDTO() {
		return suplierDTO;
	}
	public void setSuplierDTO(StoreSupplierCarPartDTO suplierDTO) {
		this.suplierDTO = suplierDTO;
	}

		
}
