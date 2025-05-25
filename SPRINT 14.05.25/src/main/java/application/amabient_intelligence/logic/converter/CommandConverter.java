package application.amabient_intelligence.logic.converter;

import org.springframework.stereotype.Component;

import application.amabient_intelligence.data.entity.CommandEntity;
import application.amabient_intelligence.logic.boundary.CommandBoundary;
import application.amabient_intelligence.logic.boundary.CommandIdBoundary;
import application.amabient_intelligence.logic.boundary.ObjectIdBoundary;
import application.amabient_intelligence.logic.boundary.TargetObjectBoundary;
import application.amabient_intelligence.logic.boundary.UserIdBoundary;

@Component
public class CommandConverter {
	public CommandBoundary toBoundary(CommandEntity entity) {
		if (entity != null) {
			CommandBoundary rv = new CommandBoundary();
			if (entity.getCommandId() != null && entity.getSystemID() != null) {
				rv.setId(new CommandIdBoundary(entity.getCommandId().toString(), entity.getSystemID()));
			}
			rv.setCommand(entity.getCommand());
			if (entity.getObjectId() != null) {
				rv.setTargetObject(new TargetObjectBoundary(
						new ObjectIdBoundary(entity.getObjectId().toString(), entity.getSystemID())));
			}
			rv.setInvocationTimestamp(entity.getInvocationTimestamp());
			if (entity.getEmail() != null) {
				rv.setInvokedBy(new UserIdBoundary(entity.getEmail(), entity.getSystemID()));
			}
			rv.setCommandAttributes(entity.getCommandAttributes());
			return rv;
		}
		return null;
	}

	public CommandEntity toEntity(CommandBoundary boundary) {
		if (boundary != null) {
			CommandEntity entity = new CommandEntity();

			entity.setCommand(boundary.getCommand());

			if (boundary.getTargetObject() != null) {
				if (!boundary.getTargetObject().getId().getObjectId().equals("string")) {
					entity.setObjectId(Long.parseLong(boundary.getTargetObject().getId().getObjectId()));
				} else {
					entity.setObjectId((long) 0);
				}
			}

			if (boundary.getInvokedBy() != null)
				entity.setEmail(boundary.getInvokedBy().getEmail());

			entity.setInvocationTimestamp(boundary.getInvocationTimestamp());

			entity.setCommandAttributes(boundary.getCommandAttributes());

			return entity;
		}
		return null;
	}
}
