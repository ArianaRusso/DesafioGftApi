package gft.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="tb_sales_order_vehicle")
public class SalesOrderVehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Seller seller;

	public SalesOrderVehicle() {
	}

	public SalesOrderVehicle(Long id, BigDecimal price, Date date, Vehicle vehicle, Customer customer, Seller seller) {
		super();
		this.id = id;
		this.price = price;
		this.date = date;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
