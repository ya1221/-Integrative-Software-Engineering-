package application.amabient_intelligence.logic.boundary;

import java.util.Date;
import java.util.Map;

public class ObjectBoundary {
	private ObjectIdBoundary id;
	private String type;
	private String alias;
	private String status;
	private boolean active;
	private Date creationTimestamp;
	private CreatedByBoundary createdBy;
	private Map<String, Object> objectDetails;

	public ObjectBoundary() {

	}

	public ObjectBoundary(ObjectIdBoundary id, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByBoundary createdBy, Map<String, Object> objectDetails) {
		super();
		this.id = id;
		this.type = type;
		this.alias = alias;
		this.status = status;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
		this.createdBy = createdBy;
		this.objectDetails = objectDetails;
	}


	public ObjectIdBoundary getId() {
		return id;
	}

	public void setId(ObjectIdBoundary id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public CreatedByBoundary getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CreatedByBoundary createdBy) {
		this.createdBy = createdBy;
	}

	public Map<String, Object> getObjectDetails() {
		return objectDetails;
	}

	public void setObjectDetails(Map<String, Object> objectDetails) {
		this.objectDetails = objectDetails;
	}

	@Override
	public String toString() {
		return "{" + "objectId: " + id.toString() + ", type: " + type + ", alias: " + alias + ", status: " + status
				+ ", active: " + active + ", creationTimestamp: " + creationTimestamp + ", createdBy: "
				+ createdBy.toString() + ", objectDetails: " + objectDetails + "}";
	}

}
