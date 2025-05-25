package application.amabient_intelligence.presatation.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.amabient_intelligence.logic.boundary.ObjectBoundary;
import application.amabient_intelligence.logic.boundary.ObjectChildIdBoundary;
import application.amabient_intelligence.logic.service.ObjectServiceWithRealtions;

@RestController
@RequestMapping(path = { "/ambient-intelligence/objects" })
public class ObjectRelationsController {
	private ObjectServiceWithRealtions object;
	
	public ObjectRelationsController(ObjectServiceWithRealtions objects) {
		this.object = objects;
	}
	
	@GetMapping(
		    path = {"/{parentSystemID}/{parentObjectId}/children"},
		    produces = { MediaType.APPLICATION_JSON_VALUE })
	public ObjectBoundary[] getAllChildren(
	   @PathVariable("parentSystemID") String parentSystemID,
	   @PathVariable("parentObjectId") String parentObjectId) {
	    return this.object.getChildren(parentSystemID, parentObjectId).toArray(new ObjectBoundary[0]);
	}

	@GetMapping(
	    path = {"/{childSystemID}/{childObjectId}/parents"},
	    produces = { MediaType.APPLICATION_JSON_VALUE })
	public ObjectBoundary[] getAllParents(
	    @PathVariable("childSystemID") String childSystemID,
	    @PathVariable("childObjectId") String childObjectId) {
	    return this.object.getParents(childSystemID, childObjectId).toArray(new ObjectBoundary[0]);
	}

	@PutMapping(
		    path = "/{parentSystemID}/{parentObjectId}/children",
		    consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public void bindObjects(
	        @PathVariable("parentSystemID") String parentSystemID,
	        @PathVariable("parentObjectId") String parentObjectId,
	        @RequestBody ObjectChildIdBoundary child) {

	    this.object.bindObjects(
	        parentSystemID,
	        parentObjectId,
	        child.getSystemID(),
	        child.getObjectId()
	    );
	}

	
}
