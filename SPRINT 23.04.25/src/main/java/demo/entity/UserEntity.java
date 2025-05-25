package demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
@KeySpace("users")
public class UserEntity {
	@Id private UserIdEntity userId;
	private String role;
	private String username;
	private String avatar;

	public UserEntity() {

	}

	public UserEntity(UserIdEntity userId, String role, String username, String avatar) {
		super();
		this.userId = userId;
		this.role = role;
		this.username = username;
		this.avatar = avatar;
	}
	public UserEntity(NewUserEntity newuserentety) {
		this.userId = new UserIdEntity(newuserentety.getEmail(),"2025b.demo");
		this.role = newuserentety.getRole();
		this.username = newuserentety.getUsername();
		this.avatar = newuserentety.getAvatar();
	}

	public UserIdEntity getUserId() {
		return userId;
	}

	public void setUserId(UserIdEntity userId) {
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
		return "UserEntity [duserId=" + userId + ", role=" + role + ", username=" + username + ", avatar=" + avatar
				+ "]";
	}

}
