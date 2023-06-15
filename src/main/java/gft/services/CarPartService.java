package gft.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.dtos.carPart.CarPartQuantityRegistrationDTO;
import gft.entities.CarPart;
import gft.entities.CarPartQuantity;
import gft.entities.StoreSupplier;
import gft.repositories.CarPartQuantityRepository;
//import gft.exceptions.EntityNotFoundException;
import gft.repositories.CarPartRepository;

@Service
public class CarPartService {

	@Autowired
	private CarPartRepository carPartRepository;
	@Autowired
	private CarPartQuantityRepository carPartQuantityRepository;
	
	
	public CarPart saveCarPart(CarPart carPart) {
		return this.carPartRepository.save(carPart);
	}
	
	public Page<CarPart> listAllCarParts(Pageable pageable){
		
		return carPartRepository.findAll(pageable);
	}

	public CarPart findCarPartById(Long id) {
		Optional<CarPart> optional = carPartRepository.findById(id);
		 optional.orElseThrow(() -> new EntityNotFoundException("CarPart não encontrada"));	
		return optional.get();
	}
	
	public List<CarPartQuantity> findCarPartsById(List<CarPartQuantityRegistrationDTO> carPartsDTO) {
		List<CarPartQuantity> carParts= new ArrayList<>();
		for(CarPartQuantityRegistrationDTO carPart : carPartsDTO) {
			Optional<CarPart> optional = carPartRepository.findById(carPart.getIdCarPart());
			CarPartQuantity carPartQuantity = new CarPartQuantity(optional.get(), carPart.getQuantity());
			carPartQuantityRepository.save(carPartQuantity);
			carParts.add(carPartQuantity);
		}
		return carParts;
	}
	
	public CarPart updateCarPart(CarPart carPart, Long id) {
		CarPart carPartOriginal = this.findCarPartById(id);
		
		carPart.setId(carPartOriginal.getId());
		return carPartRepository.save(carPart);
	}

	public void deleteCarPart(Long id) {
		CarPart carPartOriginal = this.findCarPartById(id);
		carPartRepository.delete(carPartOriginal);
	}
	
	public List<CarPart> findCarPartsByStoreSupplier(StoreSupplier storeSupplier){
		return carPartRepository.findByStoreSupplier(storeSupplier);
	} 
}
