package demo.entity;

public class CreatedByEntity {
	private UserIdEntity userId;
	
	public CreatedByEntity() {
		this.userId = null;
	}
	public CreatedByEntity(UserIdEntity userId) {
		super();
		this.userId = userId;
	}
	
	public UserIdEntity getUserId() {
		return userId;
	}

	public void setUserId(UserIdEntity userId) {
		this.userId = userId;
	}
	
}
