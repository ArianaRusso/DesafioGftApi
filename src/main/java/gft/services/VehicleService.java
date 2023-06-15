package gft.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.CarPartQuantity;
import gft.entities.Vehicle;
import gft.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private StockService stockService;

	
	public Vehicle saveVehicle (Vehicle vehicle) {
		vehicle = calculatePrice(vehicle);
		return vehicleRepository.save(vehicle);
	}

	public Page<Vehicle> listAllVehicle(Pageable pageable){
		return vehicleRepository.findAll(pageable);
		
	}
	
	public Vehicle findVehicleByModel(String model) {
		Optional<Vehicle> optional = vehicleRepository.findByModel(model);
		return optional.orElseThrow(()-> new EntityNotFoundException("Vehicle não encontrada"));
	}
	
	public Vehicle findVehicleById(Long id) {
		Optional<Vehicle> optional = vehicleRepository.findById(id);
		return optional.orElseThrow(()-> new EntityNotFoundException("Vehicle não encontrada"));
	}
	
	public void deleteVehicle (Long id) {
		Vehicle vehicle = this.findVehicleById(id);
		vehicleRepository.delete(vehicle);
		
	}
	
	public Vehicle updateVehicle (Vehicle vehicle, Long id) {
		Vehicle originalVehicle = this.findVehicleById(id);
		vehicle.setId(originalVehicle.getId());
		return vehicleRepository.save(vehicle);
	}	
	
	public Vehicle calculatePrice(Vehicle vehicle) {
		BigDecimal price, cost;
		cost = vehicle.getCost();
		price = cost.multiply(new BigDecimal(1.20));
		vehicle.setPrice(price.round(new MathContext(2)));
		return vehicle;
	}

	public Vehicle calculateCost(Vehicle vehicle) {
		BigDecimal costTotal = new BigDecimal(0), cost;
		for(CarPartQuantity carPartQuantity : vehicle.getCarPartsQuantity()) {
			cost = stockService.findStockCarPartValue(carPartQuantity.getCarPart());
			costTotal = costTotal.add(cost.multiply(new BigDecimal(carPartQuantity.getQuantity())));
		}
		
		vehicle.setCost(costTotal);
		return vehicle;
	}

}
