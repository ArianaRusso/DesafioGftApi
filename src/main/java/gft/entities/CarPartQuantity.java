package gft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tb_carpart_quantity")
public class CarPartQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private CarPart carPart;
	
	private Integer quantity;
	
	public CarPartQuantity() {}
	public CarPartQuantity(CarPart carPart, Integer quantity) {
		this.carPart = carPart;
		this.quantity = quantity;
	}
	public CarPart getCarPart() {
		return carPart;
	}
	public void setCarPart(CarPart carPart) {
		this.carPart = carPart;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
