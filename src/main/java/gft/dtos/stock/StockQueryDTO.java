package gft.dtos.stock;

import java.math.BigDecimal;

import gft.entities.CarPart;

public class StockQueryDTO {

	private Long id;
	private CarPart carPart;
	private BigDecimal cost;
	private BigDecimal price;
	private Integer quantity;
	
	public StockQueryDTO() {}
	public StockQueryDTO(Long id, CarPart carPart, BigDecimal cost, BigDecimal price, Integer quantity) {
		this.id = id;
		this.carPart = carPart;
		this.cost = cost;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CarPart getCarPart() {
		return carPart;
	}
	public void setCarPart(CarPart carPart) {
		this.carPart = carPart;
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
