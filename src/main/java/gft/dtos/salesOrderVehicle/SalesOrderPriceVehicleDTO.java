package gft.dtos.salesOrderVehicle;

import java.math.BigDecimal;

public class SalesOrderPriceVehicleDTO {
	
	private BigDecimal price;
	private String model;
	
	public SalesOrderPriceVehicleDTO(BigDecimal price, String model) {
		this.price = price;
		this.model = model;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	
}
