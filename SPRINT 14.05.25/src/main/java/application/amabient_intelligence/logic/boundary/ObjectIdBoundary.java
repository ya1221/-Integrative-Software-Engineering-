package application.amabient_intelligence.logic.boundary;

public class ObjectIdBoundary {
	private String objectId;
	private String systemID;

	public ObjectIdBoundary() {
	}

	public ObjectIdBoundary(String objectId, String systemID) {
		super();
		this.objectId = objectId;
		this.systemID = systemID;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemId) {
		this.systemID = systemId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "ObjectIdBoundary [id=" + objectId + ", systemId=" + systemID + "]";
	}

	public ObjectIdBoundary returnCopy() {
		return new ObjectIdBoundary(objectId, systemID);
	}

}
