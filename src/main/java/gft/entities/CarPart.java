package gft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "tb_carpart")
public class CarPart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	
	@ManyToOne
	private StoreSupplier storeSupplier;
	
	@OneToMany(mappedBy = "carPart")
	@JsonIgnore
	private List<Stock> stock;
	
	
	public CarPart() {}
	public CarPart(Long id, String name, String description, StoreSupplier storeSupplier) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.storeSupplier = storeSupplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Stock> getStock() {
		return stock;
	}
	
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public StoreSupplier getStoreSupplier() {
		return storeSupplier;
	}

	public void setStoreSupplier(StoreSupplier storeSupplier) {
		this.storeSupplier = storeSupplier;
	}
	
}
