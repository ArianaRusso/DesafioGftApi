package gft.dtos.vehicle;

import java.math.BigDecimal;

public class VehicleQueryDTO {
	
	private Long id;
	private String model;
	private BigDecimal price;
	private BigDecimal cost;
	
	public VehicleQueryDTO() {
	}

	public VehicleQueryDTO(Long id, String model,BigDecimal cost, BigDecimal price) {
		this.id = id;
		this.model = model;
		this.cost = cost;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	

}
