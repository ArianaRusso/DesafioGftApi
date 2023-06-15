package gft.dtos.role;

import gft.entities.Role;

public class RoleMapper {
	
	public static Role dtoToEntity (RoleRegistrationDTO dto) {
		return new Role (null, dto.getRoleName());
	}
	
	public static RoleQueryDTO entityToDto (Role role) {
		return new RoleQueryDTO (role.getId(), role.getRoleName());
	}

}
