package gft.dtos.vehicle;

import java.math.BigDecimal;

public class VehicleRegistrationImportedDTO {
	
	private String model;
	private BigDecimal cost;
	private Long idStoreSupplier;
	
	public VehicleRegistrationImportedDTO() {}
	public VehicleRegistrationImportedDTO(String model, BigDecimal cost, Long idStoreSupplier) {
		super();
		this.model = model;
		this.cost = cost;
		this.idStoreSupplier = idStoreSupplier;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Long getIdStoreSupplier() {
		return idStoreSupplier;
	}
	public void setIdStoreSupplier(Long idStoreSupplier) {
		this.idStoreSupplier = idStoreSupplier;
	}
	
}
