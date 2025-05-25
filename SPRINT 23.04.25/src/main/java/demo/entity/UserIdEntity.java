package demo.entity;

public class UserIdEntity {
	private String email;
	private String systemId;

	public UserIdEntity() {
		this.email = null;
		this.systemId = null;
	}

	public UserIdEntity(String email, String systemId) {
		super();
		this.email = email;
		this.systemId = systemId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Override
	public String toString() {
		return "UserIdEntity [email=" + email + ", systemId=" + systemId + "]";
	}
}
