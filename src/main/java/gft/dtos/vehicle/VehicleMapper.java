package gft.dtos.vehicle;

import java.util.List;

import org.springframework.stereotype.Component;

import gft.entities.CarPartQuantity;
import gft.entities.StoreSupplier;
import gft.entities.Vehicle;

@Component("VehicleMapper")
public class VehicleMapper {
	
	
	public static Vehicle dtoToEntity (VehicleRegistrationProducedDTO dto, List<CarPartQuantity> carParts, StoreSupplier storeSupplier) {
		Vehicle vehicle = new Vehicle(null, dto.getModel(),carParts,storeSupplier);
		return vehicle;
	}
	public static Vehicle dtoToEntity (VehicleRegistrationImportedDTO dto, StoreSupplier storeSupplier) {
		Vehicle vehicle = new Vehicle(null, dto.getModel(),dto.getCost(),storeSupplier);
		return vehicle;
	}
	
	public static VehicleQueryDTO entityToDto (Vehicle vehicle) {
		return new VehicleQueryDTO(vehicle.getId(), vehicle.getModel(), vehicle.getPrice(), vehicle.getCost());
	}
}
