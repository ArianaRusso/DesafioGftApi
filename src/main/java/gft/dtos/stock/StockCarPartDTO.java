package gft.dtos.stock;

import java.math.BigDecimal;

public class StockCarPartDTO {

	private Integer quantity;
	private BigDecimal cost;
	private BigDecimal totalValue;
	
	public StockCarPartDTO() {}
	public StockCarPartDTO(Integer quantity, BigDecimal cost, BigDecimal totalValue) {
		super();
		this.quantity = quantity;
		this.cost = cost;
		this.totalValue = totalValue;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
