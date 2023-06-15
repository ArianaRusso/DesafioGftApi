package gft.dtos.vehicle;

import java.util.List;

import gft.dtos.carPart.CarPartQuantityRegistrationDTO;

public class VehicleRegistrationProducedDTO {
	
	private String model;
	private List<CarPartQuantityRegistrationDTO> carParts;
	private Long idStoreSupplier;
	
	
	public VehicleRegistrationProducedDTO() {}
	public VehicleRegistrationProducedDTO(String model, List<CarPartQuantityRegistrationDTO> carParts,
			Long idStoreSupplier) {
		super();
		this.model = model;
		this.carParts = carParts;
		this.idStoreSupplier = idStoreSupplier;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<CarPartQuantityRegistrationDTO> getCarParts() {
		return carParts;
	}
	public void setCarParts(List<CarPartQuantityRegistrationDTO> carParts) {
		this.carParts = carParts;
	}
	public Long getIdStoreSupplier() {
		return idStoreSupplier;
	}
	public void setIdStoreSupplier(Long idStoreSupplier) {
		this.idStoreSupplier = idStoreSupplier;
	}

}
