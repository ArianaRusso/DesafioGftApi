package gft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
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
import gft.dtos.carPart.CarPartRegistrationDTO;
import gft.entities.CarPart;
import gft.entities.StoreSupplier;
import gft.services.CarPartService;
import gft.services.StoreSupplierService;


@RestController
@RequestMapping("carParts")
public class CarPartController {

	@Autowired
	private CarPartService carPartService;
	@Autowired
	private StoreSupplierService storeSupplierService;

	@GetMapping
	public ResponseEntity<Page<CarPartQueryDTO>> listAllCarParts(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(carPartService.listAllCarParts(pageable).map(CarPartMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<CarPartQueryDTO> saveCarPart(@RequestBody CarPartRegistrationDTO dto){
		CarPart carPart = null;
		try {
			StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
			carPart = carPartService.saveCarPart(CarPartMapper.fromDTO(dto,storeSupplier));
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(CarPartMapper.fromEntity(carPart));
	}
 
	@GetMapping("{id}")
	public ResponseEntity<CarPartQueryDTO> findCarPart(@PathVariable Long id){
			
		CarPart carPart = carPartService.findCarPartById(id);
		return ResponseEntity.ok(CarPartMapper.fromEntity(carPart));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CarPartQueryDTO> updateCarPart(@RequestBody CarPartRegistrationDTO dto, @PathVariable Long id){
		try {
			StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
			CarPart carPart = carPartService.updateCarPart(CarPartMapper.fromDTO(dto,storeSupplier), id);
			
			return ResponseEntity.ok(CarPartMapper.fromEntity(carPart));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CarPartQueryDTO> deleteCarPart(@PathVariable Long id){
		
		try {
			carPartService.deleteCarPart(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex){
			return ResponseEntity.notFound().build();
		}
		
	}
}
