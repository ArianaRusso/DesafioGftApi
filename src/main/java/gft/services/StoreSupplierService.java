package gft.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Address;
import gft.entities.CarPart;
import gft.entities.StoreSupplier;
import gft.exceptions.EntityNotFoundException;
import gft.exceptions.SQLIntegrityConstraintViolationException;
import gft.repositories.StoreSupplierRepository;
@Service
public class StoreSupplierService {
	
	@Autowired
	private CarPartService carPartService;
	
	private  StoreSupplierRepository supplierRepository;

	public StoreSupplierService(StoreSupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	public StoreSupplier saveStoreSupplier(StoreSupplier supplier) throws Exception {
		
		Address addresscep = ServiceAddress.searchAddressFor(supplier.getCep());
		
		if(addresscep.getLogradouro() != null) {
			supplier.setAddress(addresscep );
	
		}else {
			throw new SQLIntegrityConstraintViolationException("Endereço deve ser atualizado");
		}

		return supplierRepository.save(supplier);

	}

	public Page<StoreSupplier> listAllStoreSuppliers(Pageable pageable) {

		return supplierRepository.findAll(pageable);

	}

	public StoreSupplier getStoreSupplier(Long id) {
		Optional<StoreSupplier> optional = supplierRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));

	}

	public StoreSupplier updateStoreSupplier(StoreSupplier supplier, Long id) {

		StoreSupplier supplierOrigin = this.getStoreSupplier(id);

		supplier.setId(supplierOrigin.getId());

		return supplierRepository.save(supplier);

	}

	public void deleteStoreSupplier(Long id) {
		StoreSupplier supplierOrigin = this.getStoreSupplier(id);

		supplierRepository.delete(supplierOrigin);

	}

	public List<CarPart> searchSupplierProducts(StoreSupplier storeSupplier){
		
		return carPartService.findCarPartsByStoreSupplier(storeSupplier);
	}

}
