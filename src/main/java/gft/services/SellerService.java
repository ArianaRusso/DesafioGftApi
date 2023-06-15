package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Address;
import gft.entities.Seller;
import gft.exceptions.EntityNotFoundException;
import gft.exceptions.SQLIntegrityConstraintViolationException;
import gft.repositories.SellerRepository;

@Service
public class SellerService {
	
	private  SellerRepository sellerRepository;

	public SellerService(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}
	
	public Seller saveSeller(Seller seller) throws Exception {
		
		Address addresscep = ServiceAddress.searchAddressFor(seller.getCep());
		
		if(addresscep.getLogradouro() != null) {
			seller.setAddress(addresscep );
	
		}else {
			throw new SQLIntegrityConstraintViolationException("Endereço deve ser atualizado");
		}

		return sellerRepository.save(seller);

	}

	public Page<Seller> listAllSellers(Pageable pageable) {

		return sellerRepository.findAll(pageable);

	}

	public Seller getSeller(Long id) {
		Optional<Seller> optional = sellerRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado"));

	}

	public Seller updateSeller(Seller seller, Long id) {

		Seller sellerOrigin = this.getSeller(id);

		seller.setId(sellerOrigin.getId());

		return sellerRepository.save(seller);

	}

	public void deleteSeller(Long id) {
		Seller sellerOrigin = this.getSeller(id);

		sellerRepository.delete(sellerOrigin);

	}

}
