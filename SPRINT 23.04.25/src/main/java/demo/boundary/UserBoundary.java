package demo.boundary;

import demo.entity.UserEntity;
import demo.entity.UserIdEntity;

public class UserBoundary {
	private UserIdBoundary userId;
	private String role;
	private String username;
	private String avatar;

	public UserBoundary() {

	}

	public UserBoundary(UserIdBoundary userId, String role, String username, String avatar) {
		super();
		this.userId = userId;
		this.role = role;
		this.username = username;
		this.avatar = avatar;
	}

	public UserBoundary(UserEntity entity) {
		this.userId = new UserIdBoundary(entity.getUserId().getEmail(), entity.getUserId().getSystemId());
		this.role = entity.getRole();
		this.username = entity.getUsername();
		this.avatar = entity.getAvatar();
	}

	public UserIdBoundary getUserId() {
		return userId;
	}

	public void setUserId(UserIdBoundary userId) {
		this.userId = userId;
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
		return "UserBoundary [duserId=" + userId + ", role=" + role + ", username=" + username + ", avatar=" + avatar
				+ "]";
	}

	public UserEntity toEntity() {
		UserEntity rv = new UserEntity();

		if (this.userId.getSystemId() != null) {
			rv.setUserId(new UserIdEntity(this.userId.getEmail(), this.userId.getSystemId()));
		} else {
			rv.setUserId(null);
		}
		rv.setRole(this.getRole());
		rv.setAvatar(this.getAvatar());
		if (this.getUsername() != null) {
			rv.setUsername(this.getUsername());
		} else {
			rv.setUsername(null);
		}

		return rv;
	}
}
