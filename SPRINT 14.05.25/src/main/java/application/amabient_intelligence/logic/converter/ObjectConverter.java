package application.amabient_intelligence.logic.converter;


import org.springframework.stereotype.Component;

import application.amabient_intelligence.data.entity.ObjectEntity;
import application.amabient_intelligence.logic.boundary.CreatedByBoundary;
import application.amabient_intelligence.logic.boundary.ObjectBoundary;
import application.amabient_intelligence.logic.boundary.ObjectIdBoundary;
import application.amabient_intelligence.logic.boundary.UserIdBoundary;

@Component
public class ObjectConverter {

	public ObjectBoundary toBoundary(ObjectEntity entity) {
		ObjectBoundary boundary = new ObjectBoundary();

		boundary.setId(new ObjectIdBoundary(entity.getObjectId().toString(),entity.getSystemID()));
		boundary.setType(entity.getType());
		boundary.setAlias(entity.getAlias());
		boundary.setStatus(entity.getStatus());
		boundary.setActive(entity.isActive());
		boundary.setCreationTimestamp(entity.getCreationTimestamp());

		boundary.setCreatedBy(new CreatedByBoundary(new UserIdBoundary(entity.getEmail(),entity.getSystemID())));
		

		boundary.setObjectDetails(entity.getObjectDetails());
		
		return boundary;
	}

	public ObjectEntity toEntity(ObjectBoundary boundary) {
		ObjectEntity entity = new ObjectEntity();
		
		entity.setType(boundary.getType());
		entity.setAlias(boundary.getAlias());
		entity.setStatus(boundary.getStatus());
		entity.setActive(boundary.isActive());
		entity.setCreationTimestamp(boundary.getCreationTimestamp());

		if (boundary.getCreatedBy() != null && boundary.getCreatedBy().getUserId() != null) {
			UserIdBoundary u = boundary.getCreatedBy().getUserId();
			entity.setEmail(u.getEmail());
			entity.setSystemID(u.getSystemID());
		}

		entity.setObjectDetails(boundary.getObjectDetails());

		return entity;
	}	
}
