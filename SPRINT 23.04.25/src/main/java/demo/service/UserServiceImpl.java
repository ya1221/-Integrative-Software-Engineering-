package demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import demo.boundary.NewUserBoundary;
import demo.boundary.UserBoundary;
import demo.entity.UserEntity;
import demo.entity.UserIdEntity;

@Service
public class UserServiceImpl implements UserService {
	private final UserCrud userCrud;

	@Value("${spring.application.name}")
	private String systemID;

	public UserServiceImpl(UserCrud userCrud) {
		this.userCrud = userCrud;
	}

	@Override
	public UserBoundary createUser(NewUserBoundary input) {
		if (input.getEmail() == null || input.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email is required");
		}
		UserEntity entity = input.toEntity();

		entity.setUserId(new UserIdEntity(input.getEmail(), systemID));
		// entity.setCreatedAt(new Date());

		return new UserBoundary(this.userCrud.save(entity));
	}

	@Override
	public void updateUser(String systemId, String email, UserBoundary update) {
		UserEntity existing = this.userCrud.findByUserId_EmailAndUserId_SystemId(email, systemId).orElseThrow(
				() -> new RuntimeException("Could not find user by id: " + systemId + " and email " + email));

		// id could not be updated
		// email could not be updated

		if (update.getAvatar() != null) {
			existing.setAvatar(update.getAvatar());
		}

		if (update.getRole() != null) {
			existing.setRole(update.getRole());
		}

		if (update.getUsername() != null) {
			existing.setUsername(update.getUsername());
		}

		this.userCrud.save(existing);

	}

	@Override
	public Optional<UserBoundary> getUser(String systemId, String email) {
		return this.userCrud.findByUserId_EmailAndUserId_SystemId(email, systemId).map(UserBoundary::new);
	}
}
