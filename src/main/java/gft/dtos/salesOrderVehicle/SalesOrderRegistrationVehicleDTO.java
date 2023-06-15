package gft.dtos.salesOrderVehicle;

import java.math.BigDecimal;
import java.util.Date;

public class SalesOrderRegistrationVehicleDTO {
	
	private Date date;
	private BigDecimal price;
	private Long idVehicle;

	private Long idCustomer;
	private Long idSeller;
	
	public SalesOrderRegistrationVehicleDTO() {}
	public SalesOrderRegistrationVehicleDTO(Date date, BigDecimal price, Long idVehicle, Long idCustomer,
			Long idSeller) {
		super();
		this.date = date;
		this.price = price;
		this.idVehicle = idVehicle;
		this.idCustomer = idCustomer;
		this.idSeller = idSeller;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Long getIdSeller() {
		return idSeller;
	}
	public void setIdSeller(Long idSeller) {
		this.idSeller = idSeller;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
