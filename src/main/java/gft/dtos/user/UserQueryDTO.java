package gft.dtos.user;

import gft.dtos.role.RoleQueryDTO;

public class UserQueryDTO {
	
	private Long id;
	private String userName;
	private RoleQueryDTO role;
	
	public UserQueryDTO() {
	}

	public UserQueryDTO(Long id, String userName, RoleQueryDTO role) {
		this.id = id;
		this.userName = userName;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RoleQueryDTO getRole() {
		return role;
	}

	public void setRole(RoleQueryDTO role) {
		this.role = role;
	}

	
	
	
	
	
	
	
	

}
