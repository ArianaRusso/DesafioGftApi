package gft.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.CarPart;
import gft.entities.StoreSupplier;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long>{
	Page<CarPart> findAll(Pageable pageable);
	List<CarPart> findByStoreSupplier(StoreSupplier storeSupplier);
}
