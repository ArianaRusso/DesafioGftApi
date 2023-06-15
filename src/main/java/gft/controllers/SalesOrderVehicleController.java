package gft.controllers;

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

import gft.dtos.salesOrderVehicle.SalesOrderPriceVehicleDTO;
import gft.dtos.salesOrderVehicle.SalesOrderQueryVehicleDTO;
import gft.dtos.salesOrderVehicle.SalesOrderRegistrationVehicleDTO;
import gft.dtos.salesOrderVehicle.SalesOrderVehicleMapper;
import gft.entities.Customer;
import gft.entities.SalesOrderVehicle;
import gft.entities.Seller;
import gft.entities.Vehicle;
import gft.services.CustomerService;
import gft.services.SalesOrderVehicleService;
import gft.services.SellerService;
import gft.services.VehicleService;

@RestController
@RequestMapping("salesOrders")
public class SalesOrderVehicleController {
	
	@Autowired
	private SalesOrderVehicleService salesOrderVehicleService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SellerService sellerService;


		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<SalesOrderQueryVehicleDTO> saveSalesOrder (@RequestBody SalesOrderRegistrationVehicleDTO dto) {
			
			try {
				Vehicle vehicle = vehicleService.findVehicleById(dto.getIdVehicle());
				salesOrderVehicleService.verifyStockToSale(vehicle);
				Customer customer = customerService.findCustomer(dto.getIdCustomer());
				Seller seller = sellerService.getSeller(dto.getIdSeller());
				SalesOrderVehicle salesOrder = salesOrderVehicleService.saveSalesOrder(SalesOrderVehicleMapper.dtoToEntity(dto,vehicle,customer,seller));
				return ResponseEntity.ok(SalesOrderVehicleMapper.entityToDto(salesOrder));
			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
			

		}
		
		@GetMapping
		public ResponseEntity<Page<SalesOrderQueryVehicleDTO>>  listAllSalesOrder(@PageableDefault Pageable pageable){
			
			return ResponseEntity.ok(salesOrderVehicleService.listAllSalesOrder(pageable).map(SalesOrderVehicleMapper::entityToDto));
		}
				
		@GetMapping("{id}")
		public ResponseEntity<SalesOrderQueryVehicleDTO> findSalesOrderById (@PathVariable Long id) {
			
			SalesOrderVehicle salesOrder = salesOrderVehicleService.findSalesOrderById(id);
			
			return ResponseEntity.ok(SalesOrderVehicleMapper.entityToDto(salesOrder));
			
		}		

		@DeleteMapping("{id}")
		public ResponseEntity<SalesOrderQueryVehicleDTO> deleteSalesOrder (@PathVariable Long id) {
			
			try {
				salesOrderVehicleService.deleteSalesOrder(id);
				return ResponseEntity.ok().build();
				
			}catch(RuntimeException ex){
				return ResponseEntity.notFound().build();
				
			}

		}		
		
		@PutMapping("{id}")
		public ResponseEntity<SalesOrderQueryVehicleDTO> updateSalesOrder (@RequestBody SalesOrderRegistrationVehicleDTO dto, @PathVariable Long id) {
			
			try {
				Vehicle vehicle = vehicleService.findVehicleById(dto.getIdVehicle());
				salesOrderVehicleService.verifyStockToSale(vehicle);
				Customer customer = customerService.findCustomer(dto.getIdCustomer());
				Seller seller = sellerService.getSeller(dto.getIdSeller());
				SalesOrderVehicle salesOrder = salesOrderVehicleService.updateSalesOrder(SalesOrderVehicleMapper.dtoToEntity(dto,vehicle,customer,seller),id);
				return ResponseEntity.ok(SalesOrderVehicleMapper.entityToDto(salesOrder));
			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
		
			
		}
		
		@GetMapping("/price/{id}")
		public ResponseEntity<SalesOrderPriceVehicleDTO> verifyCostAndPrice (@PathVariable Long id) {
			
			Vehicle vehicle = vehicleService.findVehicleById(id);
			SalesOrderPriceVehicleDTO salesOrderPriceDTO = SalesOrderVehicleMapper.vehicleToSalesOrder(vehicle);
			
			return ResponseEntity.ok(salesOrderPriceDTO);
			
		}	

}
