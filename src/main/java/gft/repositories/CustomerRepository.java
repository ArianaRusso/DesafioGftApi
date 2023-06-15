package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Page<Customer> findAll(Pageable pageable);
}


