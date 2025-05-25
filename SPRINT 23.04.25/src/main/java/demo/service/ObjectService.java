package demo.service;

import java.util.List;
import java.util.Optional;

import demo.boundary.ObjectBoundary;

public interface ObjectService {
	  ObjectBoundary createObject(ObjectBoundary input);
	  void updateObject(String id, ObjectBoundary update);
	  Optional<ObjectBoundary> getSingleInstance(String id);
	  List<ObjectBoundary> getAllObjects();
}
