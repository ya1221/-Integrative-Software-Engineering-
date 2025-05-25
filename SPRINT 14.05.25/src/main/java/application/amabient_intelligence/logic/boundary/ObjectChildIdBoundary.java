package application.amabient_intelligence.logic.boundary;

public class ObjectChildIdBoundary {
	private String objectId;
	private String systemID;
	
	public ObjectChildIdBoundary() {
		this.objectId = null;
		this.systemID = null;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getSystemID() {
		return systemID;
	}
	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}
	
	@Override
	public String toString() {
		return "ObjectChildIdBoundary [objectId=" + objectId + ", systemID=" + systemID + "]";
	}
	
	
}
