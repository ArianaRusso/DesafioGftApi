package gft.dtos.seller;

import gft.dtos.address.AddressMapper;
import gft.entities.Seller;

public class SellerMapper {
	
	public static Seller fromDTO(SellerRegistrationDTO dto) {
		return new Seller(null, dto.getName(),dto.getCpf(), dto.getPhonenumber(), dto.getEmail(), 
				dto.getCep(), AddressMapper.fromDTO(dto.getAddress()));
	}
	
	public static SellerQueryDTO fromEntity(Seller seller) {
		return new SellerQueryDTO(seller.getId(),  seller.getName(),seller.getCpf(),
				seller.getPhonenumber(), seller.getEmail(), seller.getCep(),AddressMapper.fromEntity(seller.getAddress()));
	}

}
