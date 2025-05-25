package demo.entity;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class ObjectEntity {
	@Id
	private ObjectIdEntity id;
	private String type;
	private String alias;
	private String status;
	private boolean active;
	private Date creationTimestamp;
	private CreatedByEntity createdBy;
	private Map<String, Object> objectDetails;

	public ObjectEntity() {

	}

	public ObjectEntity(ObjectIdEntity idEntity, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByEntity createdBy, Map<String, Object> objectDetails) {
		super();
		this.id = idEntity;
		this.type = type;
		this.alias = alias;
		this.status = status;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
		this.createdBy = createdBy;
		this.objectDetails = objectDetails;
	}

	public ObjectIdEntity getIdEntity() {
		return id;
	}

	public void setId(ObjectIdEntity id) {
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

	public CreatedByEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CreatedByEntity createdBy) {
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
		return "{" + id.toString() + ", type: " + type + ", alias: " + alias + ", status: " + status + ", active: "
				+ active + ", creationTimestamp: " + creationTimestamp + ", createdBy: "
				+ (createdBy != null ? createdBy.toString() : "null") + ", objectDetails: " + objectDetails + "}";
	}

}
