package application.amabient_intelligence.data.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {
//	@Id private UserIdEntity userId;
	@Id
	private String email;
	private String systemID;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	private String username;
	private String avatar;

	public UserEntity() {

	}

	public UserEntity(String email, String systemID, UserRole role, String username, String avatar) {
		super();
		this.email = email;
		this.systemID = systemID;
		this.role = role;
		this.username = username;
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemId) {
		this.systemID = systemId;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UserEntity [email=" + email + ", systemID=" + systemID + ", role=" + role + ", username=" + username
				+ ", avatar=" + avatar + "]";
	}

}
