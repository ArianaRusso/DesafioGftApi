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

import gft.dtos.stock.StockCarPartDTO;
import gft.dtos.stock.StockMapper;
import gft.dtos.stock.StockQueryDTO;
import gft.dtos.stock.StockRegistrationDTO;
import gft.entities.CarPart;
import gft.entities.Stock;
import gft.services.CarPartService;
import gft.services.StockService;


@RestController
@RequestMapping("stock")
public class StockController {

	@Autowired
	private StockService stockService;
	@Autowired
	private CarPartService carPartService;

	@GetMapping
	public ResponseEntity<Page<StockQueryDTO>> listAllStocks(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(stockService.listAllStocks(pageable).map(StockMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<StockQueryDTO> saveStock(@RequestBody StockRegistrationDTO dto){
		Stock stock = null;
		try {
			CarPart carPart = carPartService.findCarPartById(dto.getIdCarPart());
			stock = stockService.saveStock(StockMapper.fromDTO(dto,carPart));
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(StockMapper.fromEntity(stock));
	}
 
	@GetMapping("{id}")
	public ResponseEntity<StockQueryDTO> findStock(@PathVariable Long id){
			
		Stock stock = stockService.findStock(id);
		return ResponseEntity.ok(StockMapper.fromEntity(stock));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<StockQueryDTO> updateStock(@RequestBody StockRegistrationDTO dto, @PathVariable Long id){;
		try {
			CarPart carPart = carPartService.findCarPartById(dto.getIdCarPart());
			Stock stock = stockService.updateStock(StockMapper.fromDTO(dto,carPart), id);
			return ResponseEntity.ok(StockMapper.fromEntity(stock));
		}catch(RuntimeException ex){
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<StockQueryDTO> deleteStock(@PathVariable Long id){
		
		try {
			stockService.deleteStock(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex){
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/carPart/{id}")
	public ResponseEntity<StockCarPartDTO> findStockCarPart(@PathVariable Long id){
		CarPart carPart = carPartService.findCarPartById(id);
		
		StockCarPartDTO stockCarPartDTO = stockService.findStockCarPart(carPart);
		System.out.println("\nCOST controller= "+stockCarPartDTO.getCost());
		return ResponseEntity.ok(stockCarPartDTO);
	}
	
	@GetMapping("/total")
	public ResponseEntity<StockCarPartDTO> findStockTotal(){
		
		StockCarPartDTO stockCarPartDTO = stockService.findStockTotal();
		return ResponseEntity.ok(stockCarPartDTO);
	}
}
