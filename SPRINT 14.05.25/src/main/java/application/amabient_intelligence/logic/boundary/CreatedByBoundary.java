package application.amabient_intelligence.logic.boundary;

public class CreatedByBoundary {
	private UserIdBoundary userId;
	
	public CreatedByBoundary() {
		this.userId = null;
	}
	public CreatedByBoundary(UserIdBoundary userId) {
		super();
		this.userId = userId;
	}
	
	public UserIdBoundary getUserId() {
		return userId;
	}

	public void setUserId(UserIdBoundary userId) {
		this.userId = userId;
	}
	
	
	public CreatedByBoundary copy(CreatedByBoundary o) {
		this.setUserId(o.getUserId());
		return this;
	}
	
	
}
