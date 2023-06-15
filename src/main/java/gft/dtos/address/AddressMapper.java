package gft.dtos.address;

import gft.entities.Address;

public class AddressMapper {
	
	public static Address fromDTO(AddressDTO dto) {
		return new Address(dto.getBairro(),dto.getComplemento(),dto.getLocalidade(),dto.getLogradouro(),dto.getUf());
	}
	
	public static AddressDTO fromEntity(Address address) {
		
		return new AddressDTO(address.getBairro(), address.getComplemento(), 
				address.getLocalidade(),  address.getLogradouro(), address.getUf());
		
	}

}
