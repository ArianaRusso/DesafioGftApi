package gft.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tb_vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String model;
	
	private BigDecimal cost;
	
	private BigDecimal price;
	
	@OneToOne
	@JoinColumn(name = "saleOrder_id")
	private SalesOrderVehicle saleOrder;
	
	@ManyToMany
	private List<CarPartQuantity> carPartsQuantity;
	
	@ManyToOne
	private StoreSupplier storeSupplier;

	public Vehicle() {
	}
	
	public Vehicle(Long id, String model, List<CarPartQuantity> carPartsQuantity, StoreSupplier storeSupplier) {
		this.id = id;
		this.model = model;
		this.carPartsQuantity = carPartsQuantity;
		this.storeSupplier = storeSupplier;
	}
	public Vehicle(Long id, String model, BigDecimal cost, StoreSupplier storeSupplier) {
		this.id = id;
		this.model = model;
		this.cost = cost;
		this.storeSupplier = storeSupplier;
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

	public List<CarPartQuantity> getCarPartsQuantity() {
		return carPartsQuantity;
	}

	public void setCarPartsQuantity(List<CarPartQuantity> carPartsQuantity) {
		this.carPartsQuantity = carPartsQuantity;
	}

	public SalesOrderVehicle getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SalesOrderVehicle saleOrder) {
		this.saleOrder = saleOrder;
	}

	public StoreSupplier getStoreSupplier() {
		return storeSupplier;
	}

	public void setStoreSupplier(StoreSupplier storeSupplier) {
		this.storeSupplier = storeSupplier;
	}
	
	

}
