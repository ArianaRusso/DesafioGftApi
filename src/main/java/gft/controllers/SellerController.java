package gft.controllers;

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

import gft.dtos.seller.SellerMapper;
import gft.dtos.seller.SellerQueryDTO;
import gft.dtos.seller.SellerRegistrationDTO;
import gft.entities.Seller;
import gft.services.SellerService;

@RestController
@RequestMapping("sellers")
public class SellerController {
	
	private final SellerService sellerService;

	public SellerController(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	
	@GetMapping
	public ResponseEntity<Page<SellerQueryDTO>> listAllSellers(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(sellerService.listAllSellers(pageable).map(SellerMapper::fromEntity));		
			
		
	}
	
	@PostMapping
	public ResponseEntity<SellerQueryDTO> saveSeller(@RequestBody SellerRegistrationDTO dto)throws Exception{
		
		Seller seller = sellerService.saveSeller(SellerMapper.fromDTO(dto));
		
		return ResponseEntity.ok(SellerMapper.fromEntity(seller));
		
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<SellerQueryDTO> searchSeller(@PathVariable Long id){

		Seller seller = sellerService.getSeller(id);
		
		return ResponseEntity.ok(SellerMapper.fromEntity(seller));
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<SellerQueryDTO> updateSeller(@RequestBody SellerRegistrationDTO dto,
			@PathVariable Long id){
		
		try {
		
			Seller seller = sellerService.updateSeller(SellerMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(SellerMapper.fromEntity(seller));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<SellerQueryDTO> deleteSeller(@PathVariable Long id){
		
		try {
			sellerService.deleteSeller(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	

	

}
