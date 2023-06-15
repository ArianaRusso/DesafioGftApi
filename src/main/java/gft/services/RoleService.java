package gft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gft.entities.Role;
import gft.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public Role saveRole(Role role) {
		return roleRepository.save(role);
		
	}

}
