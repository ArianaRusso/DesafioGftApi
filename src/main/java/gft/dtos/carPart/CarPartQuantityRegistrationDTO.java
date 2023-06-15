package gft.dtos.carPart;

public class CarPartQuantityRegistrationDTO {

	private Long idCarPart;
	private Integer quantity;
	
	public CarPartQuantityRegistrationDTO() {}
	public CarPartQuantityRegistrationDTO(Long idCarPart, Integer quantity) {
		this.idCarPart = idCarPart;
		this.quantity = quantity;
	}
	
	public Long getIdCarPart() {
		return idCarPart;
	}
	public void setIdCarPart(Long idCarPart) {
		this.idCarPart = idCarPart;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
