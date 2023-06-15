package gft.dtos.user;

public class UserRegistrationDTO {
	
	private String userName;
	
	private String password;
	
	private Long roleId;

	public UserRegistrationDTO() {
	}

	public UserRegistrationDTO(String userName, String password, Long roleId) {
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleID) {
		this.roleId = roleID;
	}
	
	
	
	
	
	
	
	

}
