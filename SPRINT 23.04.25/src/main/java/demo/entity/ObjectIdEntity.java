package demo.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class ObjectIdEntity {
	@Id
	private Long objectId;
	private String systemID;

	public ObjectIdEntity() {
		this.objectId = null;
		this.systemID = null;
	}

	public ObjectIdEntity(Long objectId, String systemId) {
		this.objectId = objectId;
		this.systemID = systemId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ObjectIdEntity))
			return false;
		ObjectIdEntity that = (ObjectIdEntity) o;
		return objectId == that.objectId && Objects.equals(systemID, that.systemID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectId, systemID);
	}

	@Override
	public String toString() {
		return "ObjectIdEntity [id=" + objectId + ", systemId=" + systemID + "]";
	}
}
