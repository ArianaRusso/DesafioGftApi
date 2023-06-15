package gft.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	List<Stock> findByCarPartId(Long id);
	Page<Stock> findAll(Pageable pageable);
	List<Stock> findAll();
}
