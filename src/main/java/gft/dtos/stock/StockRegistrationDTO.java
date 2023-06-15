package gft.dtos.stock;

import java.math.BigDecimal;

public class StockRegistrationDTO {

	private Long idCarPart;
	private BigDecimal cost;
	private BigDecimal price;
	private Integer quantity;
	
	public StockRegistrationDTO() {}
	public StockRegistrationDTO(Long idCarPart, BigDecimal cost, BigDecimal price, Integer quantity) {
		this.idCarPart = idCarPart;
		this.cost = cost;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getIdCarPart() {
		return idCarPart;
	}
	public void setIdCarPart(Long idCarPart) {
		this.idCarPart = idCarPart;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
