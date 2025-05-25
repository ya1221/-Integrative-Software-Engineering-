package application.amabient_intelligence.logic.service;

import java.util.List;
import java.util.Optional;

import application.amabient_intelligence.logic.boundary.ObjectBoundary;

public interface ObjectService {
	  public ObjectBoundary createObject(ObjectBoundary input);
	  public void updateObject(String id, ObjectBoundary update);
	  public Optional<ObjectBoundary> getSingleInstance(String id);
	  public List<ObjectBoundary> getAllObjects();
	  public void deleteAllObjects();	  
	  
}
