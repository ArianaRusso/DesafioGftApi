package gft.dtos.role;

import gft.enun.TypeRole;

public class RoleRegistrationDTO {
	
	private TypeRole roleName;
	
	public RoleRegistrationDTO() {
	}

	public RoleRegistrationDTO(TypeRole roleName) {
		this.roleName = roleName;
	}

	public TypeRole getRoleName() {
		return roleName;
	}

	public void setRoleName(TypeRole roleName) {
		this.roleName = roleName;
	} 
	
	
	
	

}
