package gft.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.SalesOrderVehicle;

@Repository
public interface SalesOrderVehicleRepository extends JpaRepository<SalesOrderVehicle, Long>{
	Page<SalesOrderVehicle> findAll(Pageable pageable);
}
