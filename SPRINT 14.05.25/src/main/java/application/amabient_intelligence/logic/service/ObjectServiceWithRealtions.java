package application.amabient_intelligence.logic.service;
import java.util.List;

import application.amabient_intelligence.logic.boundary.ObjectBoundary;

public interface ObjectServiceWithRealtions extends ObjectService{
	public List<ObjectBoundary> getChildren(String parentSysemID, String parentObjectId);
	public List<ObjectBoundary> getParents(String childSystemID, String childObjectId);
	public void bindObjects(String parentSystemID, String parentObjectId, String childSystemID, String childObjectId);

}
