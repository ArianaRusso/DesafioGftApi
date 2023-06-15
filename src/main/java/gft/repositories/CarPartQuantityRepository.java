package gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.CarPartQuantity;

@Repository
public interface CarPartQuantityRepository extends JpaRepository<CarPartQuantity, Long>{

}
