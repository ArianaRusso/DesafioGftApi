package gft.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	Optional <Vehicle> findByModel (String model);
	
	Page<Vehicle> findAll(Pageable pageable);

}
