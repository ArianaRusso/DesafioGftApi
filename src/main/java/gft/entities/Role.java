package gft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import gft.enun.TypeRole;

@Entity
@Table(name ="tb_role")
public class Role implements GrantedAuthority, Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TypeRole roleName;
	
	
	public Role() {
	}

	

	public Role(Long id, TypeRole roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	 public TypeRole getRoleName() {
		return roleName;
	}

	public void setRoleName(TypeRole roleName) {
		this.roleName = roleName;
	}

	@Override
	    public String getAuthority() {
	        return this.roleName.toString();
	    }



	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
	
	
}
