package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.StoreSupplier;


@Repository
public interface StoreSupplierRepository extends JpaRepository<StoreSupplier, Long>{

	Page<StoreSupplier> findAll(Pageable pageable);
	
	
}

