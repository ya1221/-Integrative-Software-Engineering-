package demo.boundary;

import demo.entity.NewUserEntity;
import demo.entity.UserEntity;

public class NewUserBoundary {
	private String email;
	private String role;
	private String username;
	private String avatar;

	public NewUserBoundary() {

	}

	public NewUserBoundary(String email, String role, String username, String avatar) {
		super();
		this.email = email;
		this.role = role;
		this.username = username;
		this.avatar = avatar;
	}

	public NewUserBoundary(NewUserEntity entity) {
		this.email = entity.getEmail();
		this.role = entity.getRole();
		this.username = entity.getUsername();
		this.avatar = entity.getAvatar();
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
		return "UserBoundary [email=" + email + ", role=" + role + ", username=" + username + ", avatar=" + avatar
				+ "]";
	}

	public UserEntity toEntity() {
		NewUserEntity rv = new NewUserEntity();

		if (this.getEmail() != null) {
			rv.setEmail(this.getEmail());
		} else {
			rv.setEmail(null);
		}
		rv.setRole(this.getRole());
		rv.setAvatar(this.getAvatar());
		if (this.getUsername() != null) {
			rv.setUsername(this.getUsername());
		} else {
			rv.setUsername(null);
		}
		UserEntity ue = new UserEntity(rv);
		return ue;
	}

}