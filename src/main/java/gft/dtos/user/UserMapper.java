package gft.dtos.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gft.dtos.role.RoleMapper;
import gft.entities.Role;
import gft.entities.UserModel;

public class UserMapper {
	
	public static UserModel dtoToEntity (UserRegistrationDTO dto) {
		Role role = new Role();
		role.setId(dto.getRoleId());
		return new UserModel(null, dto.getUserName(), new BCryptPasswordEncoder().encode(dto.getPassword()), role);
	}
	
	public static UserQueryDTO entityToDto (UserModel user) {
		return new UserQueryDTO(user.getId(), user.getUserName(), RoleMapper.entityToDto(user.getRole()));
	}

}