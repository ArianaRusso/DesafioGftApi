package gft.dtos.salesOrderVehicle;

import java.math.BigDecimal;
import java.util.Date;

import gft.dtos.vehicle.VehicleQueryDTO;
import gft.entities.Customer;
import gft.entities.Seller;

public class SalesOrderQueryVehicleDTO {
	
	private Long id;
	private Date date;
	private BigDecimal price;
	private VehicleQueryDTO vehicle;
	
	private Customer customer;
	private Seller seller;
	
	public SalesOrderQueryVehicleDTO() {
	}
	public SalesOrderQueryVehicleDTO(Long id, Date date, BigDecimal price, VehicleQueryDTO vehicle, Customer customer,
			Seller seller) {
		this.id = id;
		this.date = date;
		this.price = price;
		this.vehicle = vehicle;
		this.customer = customer;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public VehicleQueryDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleQueryDTO vehicle) {
		this.vehicle = vehicle;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	

}
