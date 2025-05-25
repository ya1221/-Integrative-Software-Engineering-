package application.amabient_intelligence.logic.converter;

import org.springframework.stereotype.Component;

import application.amabient_intelligence.data.entity.UserEntity;
import application.amabient_intelligence.logic.boundary.UserBoundary;
import application.amabient_intelligence.logic.boundary.UserIdBoundary;

@Component
public class UserConverter {
	public UserBoundary toBoundary(UserEntity entity) {
		if (entity != null) {
			UserBoundary rv = new UserBoundary();

			if (entity.getEmail() != null && entity.getSystemID() != null)
				rv.setUserId(new UserIdBoundary(entity.getEmail(), entity.getSystemID()));
			rv.setRole(entity.getRole());
			rv.setUsername(entity.getUsername());
			rv.setAvatar(entity.getAvatar());
		}
		return null;
	}

	public UserEntity toEntity(UserBoundary boundary) {
		if (boundary != null) {
			UserEntity rv = new UserEntity();

			if (boundary.getUserId() != null) {
				rv.setEmail(boundary.getUserId().getEmail());
				rv.setSystemID(boundary.getUserId().getSystemID());
			}

			rv.setRole(boundary.getRole());
			rv.setAvatar(boundary.getAvatar());
			rv.setUsername(boundary.getUsername());
			return rv;
		}
		return null;
	}

}
