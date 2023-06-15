package gft.dtos.role;

import gft.enun.TypeRole;

public class RoleQueryDTO {
	
	private Long id;
	
	private TypeRole rolename;

	public RoleQueryDTO() {
	}

	public RoleQueryDTO(Long id, TypeRole rolename) {
		this.id = id;
		this.rolename = rolename;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeRole getRolename() {
		return rolename;
	}

	public void setRolename(TypeRole rolename) {
		this.rolename = rolename;
	}
	
	
	
	
	
	
	

}
