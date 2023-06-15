package gft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gft.dtos.vehicle.VehicleMapper;
import gft.dtos.vehicle.VehicleQueryDTO;
import gft.dtos.vehicle.VehicleRegistrationImportedDTO;
import gft.dtos.vehicle.VehicleRegistrationProducedDTO;
import gft.entities.CarPartQuantity;
import gft.entities.StoreSupplier;
import gft.entities.Vehicle;
import gft.services.CarPartService;
import gft.services.StoreSupplierService;
import gft.services.VehicleService;

@RestController
@RequestMapping("vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private CarPartService carPartService;
	@Autowired
	private StoreSupplierService storeSupplierService;
	
		@PostMapping("/imported")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<VehicleQueryDTO> saveVehicleImported (@RequestBody VehicleRegistrationImportedDTO dto) {
			try {
				StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
				Vehicle vehicle = vehicleService.saveVehicle(VehicleMapper.dtoToEntity(dto, storeSupplier));
				return ResponseEntity.ok(VehicleMapper.entityToDto(vehicle));

			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
			
		}
		
		@PostMapping("/produced")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<VehicleQueryDTO> saveVehicleProduced (@RequestBody VehicleRegistrationProducedDTO dto) {
			try {
				StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
				List<CarPartQuantity> carParts = carPartService.findCarPartsById(dto.getCarParts());
				
				Vehicle vehicle = vehicleService.calculateCost(VehicleMapper.dtoToEntity(dto, carParts, storeSupplier));
				vehicle =vehicleService.saveVehicle(vehicle);
				return ResponseEntity.ok(VehicleMapper.entityToDto(vehicle));

			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
			
		}
		
		@GetMapping
		public ResponseEntity<Page<VehicleQueryDTO>>  listAllVehicle(@PageableDefault Pageable pageable){
			
			return ResponseEntity.ok(vehicleService.listAllVehicle(pageable).map(VehicleMapper::entityToDto));
		}

		
		
		@GetMapping("{id}")
		public ResponseEntity<VehicleQueryDTO> findVehicleById (@PathVariable Long id) {
			
			Vehicle vehicle = vehicleService.findVehicleById(id);
			
			return ResponseEntity.ok(VehicleMapper.entityToDto(vehicle));
			
		}
		

		@DeleteMapping("{id}")
		public ResponseEntity<VehicleQueryDTO> deleteVehicle (@PathVariable Long id) {
			
			try {
				vehicleService.deleteVehicle(id);
				return ResponseEntity.ok().build();
				
			}catch(RuntimeException ex){
				return ResponseEntity.notFound().build();
				
			}

		}
		
		
		@PutMapping("/imported/{id}")
		public ResponseEntity<VehicleQueryDTO> updateVehicleImported (@RequestBody VehicleRegistrationImportedDTO dto, @PathVariable Long id) {
			
			try {
				StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
				Vehicle vehicle = vehicleService.updateVehicle(VehicleMapper.dtoToEntity(dto, storeSupplier),id);
				return ResponseEntity.ok(VehicleMapper.entityToDto(vehicle));

			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
			
		}
		@PutMapping("/produced/{id}")
		public ResponseEntity<VehicleQueryDTO> updateVehicleProduced (@RequestBody VehicleRegistrationProducedDTO dto, @PathVariable Long id) {
			
			try {
				StoreSupplier storeSupplier = storeSupplierService.getStoreSupplier(dto.getIdStoreSupplier());
				List<CarPartQuantity> carParts = carPartService.findCarPartsById(dto.getCarParts());
				
				Vehicle vehicle = vehicleService.calculateCost(VehicleMapper.dtoToEntity(dto, carParts, storeSupplier));
				vehicle =vehicleService.saveVehicle(vehicle);
				return ResponseEntity.ok(VehicleMapper.entityToDto(vehicle));

			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
			
		}

}
