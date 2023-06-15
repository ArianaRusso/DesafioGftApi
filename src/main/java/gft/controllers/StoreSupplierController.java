package gft.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dtos.carPart.CarPartMapper;
import gft.dtos.carPart.CarPartQueryDTO;
import gft.dtos.storeSupplier.StoreSupplierMapper;
import gft.dtos.storeSupplier.StoreSupplierQueryDTO;
import gft.dtos.storeSupplier.StoreSupplierRegistrationDTO;
import gft.entities.StoreSupplier;
import gft.services.StoreSupplierService;

@RestController
@RequestMapping("suppliers")
public class StoreSupplierController {

private final StoreSupplierService supplierService;
	
	public StoreSupplierController(StoreSupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping
	public ResponseEntity<Page<StoreSupplierQueryDTO>> searchAllSuppliers(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(supplierService.listAllStoreSuppliers(pageable).map(StoreSupplierMapper::fromEntity));		
			
		
	}
	
	@PostMapping
	public ResponseEntity<StoreSupplierQueryDTO> saveSupplier(@RequestBody StoreSupplierRegistrationDTO dto)throws Exception{
		
		StoreSupplier supplier = supplierService.saveStoreSupplier(StoreSupplierMapper.fromDTO(dto));
		
		return ResponseEntity.ok(StoreSupplierMapper.fromEntity(supplier));
		
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<StoreSupplierQueryDTO> searchSupplier(@PathVariable Long id){

		StoreSupplier storesupplier = supplierService.getStoreSupplier(id);
		
		return ResponseEntity.ok(StoreSupplierMapper.fromEntity(storesupplier));
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<StoreSupplierQueryDTO> alterStoreSupplier(@RequestBody StoreSupplierRegistrationDTO dto,
			@PathVariable Long id){
		
		try {
		
			StoreSupplier storesupplier = supplierService.updateStoreSupplier(StoreSupplierMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(StoreSupplierMapper.fromEntity(storesupplier));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<StoreSupplierQueryDTO> deleteSupplier(@PathVariable Long id){
		
		try {
			
			supplierService.deleteStoreSupplier(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("{id}/products") 
	public ResponseEntity<List<CarPartQueryDTO>> searchSupplierProducts(@PathVariable Long id){

		StoreSupplier storeSupplier = supplierService.getStoreSupplier(id);
		List<CarPartQueryDTO> carPartsDTO= CarPartMapper.fromEntity(supplierService.searchSupplierProducts(storeSupplier));
		return ResponseEntity.ok(carPartsDTO);
			
	}

}
