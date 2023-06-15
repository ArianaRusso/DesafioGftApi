package gft.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import gft.entities.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional <UserModel> findByUserName (String userName);
	
	Page<UserModel> findAll(Pageable pageable);

}
