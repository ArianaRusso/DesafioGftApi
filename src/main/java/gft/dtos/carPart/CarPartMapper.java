package gft.dtos.carPart;


import java.util.ArrayList;
import java.util.List;

import gft.dtos.storeSupplier.StoreSupplierMapper;
import gft.entities.CarPart;
import gft.entities.StoreSupplier;

public class CarPartMapper {

	public static CarPart fromDTO(CarPartRegistrationDTO dto, StoreSupplier storeSupplier) {
		return new CarPart(null, dto.getName(), dto.getDescription(), storeSupplier);
	}
	
	public static CarPartQueryDTO fromEntity(CarPart carPart) {
		return new CarPartQueryDTO(carPart.getId(), carPart.getName(), carPart.getDescription(), StoreSupplierMapper.storeSupplierCarPartDTO(carPart.getStoreSupplier()));
	}

	public static List<CarPartQueryDTO>  fromEntity(List<CarPart> carParts) {
		List<CarPartQueryDTO> dtos = new ArrayList<CarPartQueryDTO>();
		for(CarPart carPart : carParts) {
			dtos.add(fromEntity(carPart));
		}
		return dtos;
	}
}
