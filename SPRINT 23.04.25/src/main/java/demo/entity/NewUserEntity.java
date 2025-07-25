package demo.entity;

import org.springframework.data.annotation.Id;

public class NewUserEntity {
	private String email;
	private String role;
	private String username;
	private String avatar;

	public NewUserEntity() {

	}

	public NewUserEntity(String email, String role, String username, String avatar) {
		super();
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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
		return "UserEntity [email=" + email + ", role=" + role + ", username=" + username + ", avatar=" + avatar
				+ "]";
	}

}
