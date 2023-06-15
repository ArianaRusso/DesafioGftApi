package gft.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Seller;


@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{
	
	Page<Seller> findAll(Pageable pageable);



}
