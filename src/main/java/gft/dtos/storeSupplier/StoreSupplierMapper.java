package gft.dtos.storeSupplier;

import gft.dtos.address.AddressMapper;
import gft.entities.StoreSupplier;


public class StoreSupplierMapper {
	
	public static StoreSupplier fromDTO(StoreSupplierRegistrationDTO dto) {
		return new StoreSupplier(null, dto.getCnpj(), dto.getName(), dto.getPhonenumber(), dto.getEmail(), dto.getCep(), AddressMapper.fromDTO(dto.getAddress()));
	}
	
	public static StoreSupplierQueryDTO fromEntity(StoreSupplier supplier) {
		return new StoreSupplierQueryDTO(supplier.getId(), supplier.getCnpj(), supplier.getName(),
				supplier.getPhonenumber(), supplier.getEmail(), supplier.getCep(),AddressMapper.fromEntity(supplier.getAddress()));
	}

	public static StoreSupplierCarPartDTO storeSupplierCarPartDTO(StoreSupplier supplier) {
		return new StoreSupplierCarPartDTO(supplier.getName(), supplier.getPhonenumber(), supplier.getEmail());
	}
}
