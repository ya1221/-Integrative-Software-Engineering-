package application.amabient_intelligence.logic.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.amabient_intelligence.data.IdGenerator;
import application.amabient_intelligence.data.crud.IdGeneratorCrud;
import application.amabient_intelligence.data.crud.ObjectCrud;
import application.amabient_intelligence.data.entity.ObjectEntity;
import application.amabient_intelligence.logic.boundary.ObjectBoundary;
import application.amabient_intelligence.logic.converter.ObjectConverter;
import application.amabient_intelligence.logic.exception.ForbiddenException;
import application.amabient_intelligence.logic.exception.InvalidInputException;
import application.amabient_intelligence.logic.exception.NotFoundException;

import java.util.AbstractMap;
import java.util.stream.Stream;

@Service
public class ObjectServiceImpl implements ObjectServiceWithRealtions {
	private final ObjectCrud objectCrud;
	private final IdGeneratorCrud idGeneratorCrud;
	private final ObjectConverter objectConverter;
	private String systemID;


	public ObjectServiceImpl(ObjectCrud objectCrud, IdGeneratorCrud idGeneratorCrud, ObjectConverter objectConverter) {
		this.objectCrud = objectCrud;
		this.idGeneratorCrud = idGeneratorCrud;
		this.objectConverter = objectConverter;
	}

	@Value("${spring.application.name}")
	public void setSystemID(String systemID) {
	    this.systemID = systemID;
	}


	@Override
	@Transactional(readOnly = false) 
	public ObjectBoundary createObject(ObjectBoundary boundary) {
		if (boundary.getType() == null || boundary.getType().trim().isEmpty())
            throw new InvalidInputException("Missing type");
	  
		ObjectEntity entity = this.objectConverter.toEntity(boundary);
		
		entity.setSystemID(this.systemID);
		IdGenerator tmp = this.idGeneratorCrud.save(new IdGenerator());
		entity.setObjectId(tmp.getId());
		this.idGeneratorCrud.delete(tmp);
		entity.setCreationTimestamp(new Date());

		return this.objectConverter.toBoundary(this.objectCrud.save(entity));
	}


	@Override
	@Transactional(readOnly = false)
	public void updateObject(String objectId, ObjectBoundary update) {
		Long id;
		try {
	    	id = Long.parseLong(objectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid parentObjectId: " + objectId);
		}
		
		ObjectEntity existing = this.objectCrud.findById(id)
				.orElseThrow(() -> new NotFoundException("Could not find object by id: " + id));
		
		if (!"string".equals(update.getId().getObjectId()) && 
				!update.getId().getObjectId().equals(String.valueOf(existing.getObjectId()))) {
			    throw new ForbiddenException("You are not authorized to change this object's id");
		}
		
		if (!"string".equals(update.getId().getSystemID()) && update.getId().getSystemID() != existing.getSystemID()) {
			throw new ForbiddenException("You are not authorized to change this object's system id");
		}
		
		if (update.getType() != null) {
			existing.setType(update.getType());
		}

		if (update.getAlias() != null) {
			existing.setAlias(update.getAlias());
		}

		if (update.getStatus() != null) {
			existing.setStatus(update.getStatus());
		}

		if (update.getType() != null) {
			existing.setType(update.getType());
		}

		// no need to check if null since it is boolean and not Boolean
		existing.setActive(update.isActive());

		if (update.getObjectDetails() != null) {
			existing.setObjectDetails(update.getObjectDetails());
		}

		this.objectCrud.save(existing);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ObjectBoundary> getSingleInstance(String objectId) {
		Long id;
		try {
	    	id = Long.parseLong(objectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid parentObjectId: " + objectId);
		}
		
		return this.objectCrud.findById(id).map(this.objectConverter::toBoundary);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ObjectBoundary> getAllObjects() {
		List<ObjectEntity> entities = this.objectCrud.findAll();

	    if (entities.isEmpty()) {
	        throw new NotFoundException("No objects found");
	    }

	    return entities.stream()
	            .map(this.objectConverter::toBoundary)
	            .toList();
	}

	@Override
	@Transactional
	public void deleteAllObjects() {
		this.objectCrud.deleteAll();
	}


	@Override
	@Transactional(readOnly = true)
	public List<ObjectBoundary> getChildren(String parentSystemID, String parentObjectId) {
	    Long id;
	    try {
	    	id = Long.parseLong(parentObjectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid parentObjectId: " + parentObjectId);
		}
	    
	    ObjectEntity parent = this.objectCrud
	        .findBySystemIDAndObjectId(parentSystemID, id)
	        .orElseThrow(() -> new NotFoundException("Parent object not found"));

	    List<ObjectEntity> children = parent.getChildrens();

	    if (children.isEmpty()) {
	        throw new NotFoundException("No children found for this parent");
	    }

	    return children.stream()
	        .map(this.objectConverter::toBoundary)
	        .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ObjectBoundary> getParents(String childSystemID, String childObjectId) {
	    Long id;
	    try {
	    	id = Long.parseLong(childObjectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid parentObjectId: " + childObjectId);
		}
	    
	    ObjectEntity child = this.objectCrud
	        .findBySystemIDAndObjectId(childSystemID, id)
	        .orElseThrow(() -> new NotFoundException("Child object not found"));

	    List<ObjectEntity> parents = child.getParents();

	    if (parents.isEmpty()) {
	        throw new NotFoundException("No parents found for this child");
	    }

	    return parents.stream()
	        .map(this.objectConverter::toBoundary)
	        .toList();
	}
	
	@Override
	@Transactional(readOnly = false)
	public void bindObjects(String parentSystemID, String parentObjectId, String childSystemID, String childObjectId) {
		Long parentId;
		try {
		    parentId = Long.parseLong(parentObjectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid parentObjectId: " + parentObjectId);
		}

		Long childId;
		try {
		    childId = Long.parseLong(childObjectId);
		} catch (NumberFormatException e) {
		    throw new InvalidInputException("Invalid childObjectId: " + childObjectId);
		}
		
		Stream.of(
			    new AbstractMap.SimpleEntry<>("parentSystemID", parentSystemID),
			    new AbstractMap.SimpleEntry<>("childSystemID", childSystemID)
			).forEach(entry -> {
			    if (entry.getValue() == null || entry.getValue().trim().isEmpty()) {
			        throw new InvalidInputException("Missing or empty " + entry.getKey());
			    }
			});

	    ObjectEntity parent = this.objectCrud
	        .findBySystemIDAndObjectId(parentSystemID, parentId)
	        .orElseThrow(() -> new InvalidInputException("Invalid input from Parent object"));

	    ObjectEntity child = this.objectCrud
	        .findBySystemIDAndObjectId(childSystemID, childId)
	        .orElseThrow(() -> new InvalidInputException("Invalid input from Child object"));

	    parent.getChildrens().add(child);
	    child.getParents().add(parent);

	    this.objectCrud.save(parent);
	    this.objectCrud.save(child);
		

	}

}
