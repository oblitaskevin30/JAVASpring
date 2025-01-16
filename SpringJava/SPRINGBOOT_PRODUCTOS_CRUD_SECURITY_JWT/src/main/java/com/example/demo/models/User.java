package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;



@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	@ManyToMany
	@JoinTable(
			name ="tb_user_rol",
			joinColumns=@JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_rol"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user","id_rol"})}
			)
	private List<Rol> roles;
	
	@Transient
	private boolean admin;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", roles=" + roles
				+ "]";
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
