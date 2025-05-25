package application.amabient_intelligence.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.amabient_intelligence.data.crud.UserCrud;
import application.amabient_intelligence.data.entity.UserEntity;
import application.amabient_intelligence.data.entity.UserRole;
import application.amabient_intelligence.logic.boundary.UserBoundary;
import application.amabient_intelligence.logic.boundary.UserIdBoundary;
import application.amabient_intelligence.logic.converter.UserConverter;
import application.amabient_intelligence.logic.exception.ForbiddenException;
import application.amabient_intelligence.logic.exception.InvalidInputException;
import application.amabient_intelligence.logic.exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private final UserCrud userCrud;
	private UserConverter userConverter;

	private String systemID;

	public UserServiceImpl(UserCrud userCrud, UserConverter userConverter) {
		this.userCrud = userCrud;
		this.userConverter = userConverter;
	}

	@Value("${spring.application.name}")
	public void setSystemID(String systemID) {
		this.systemID = systemID;
		System.err.println("*** " + this.systemID);
	}

	@Override
	@Transactional(readOnly = false) // defualt = not read only
	public UserBoundary createUser(UserBoundary user) {
		if (user.getUserId().getEmail() == null || user.getUserId().getEmail().trim().isEmpty())
			throw new InvalidInputException("Email is required");

		validateEmail(user.getUserId().getEmail());

		checkInputUser(user);

		UserEntity entity = this.userConverter.toEntity(user);

		entity.setEmail(user.getUserId().getEmail());
		entity.setSystemID(systemID);

		userCrud.save(entity);
		return userConverter.toBoundary(entity);
	}

	public void validateEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if (!email.matches(emailRegex)) {
			throw new InvalidInputException("Invalid email format: " + email);
		}
	}

	public void checkInputUser(UserBoundary user) {
		if (user.getRole() == null || (user.getRole() != UserRole.ADMIN && user.getRole() != UserRole.OPERATOR
				&& user.getRole() != UserRole.END_USER))
			throw new InvalidInputException("Role needs to be valid input");

		if (user.getUsername() == null)
			throw new InvalidInputException("User name is required");

		if (user.getAvatar() == null)
			throw new InvalidInputException("Avatar is required");
	}

	@Override
	@Transactional(readOnly = true)
	public UserBoundary login(String systemId, String userEmail) {
		return userConverter.toBoundary(this.userCrud.findByEmailAndSystemID(userEmail, systemId).orElseThrow(
				() -> new ForbiddenException("Could not find user by id: " + systemId + " and email " + userEmail)));
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(String systemId, String userEmail, UserBoundary update) {
		UserEntity existing = this.userCrud.findByEmailAndSystemID(userEmail, systemId).orElseThrow(
				() -> new NotFoundException("Could not find user by id: " + systemId + " and email " + userEmail));

		// id could not be updated
		// email could not be updated

		if (!update.getUserId().getSystemID().equals(systemId))
			throw new InvalidInputException("email update is not allowed");

		if (!update.getUserId().getEmail().equals(userEmail))
			throw new InvalidInputException("systemID update is not allowed");

		checkInputUser(update);

		existing.setAvatar(update.getAvatar());

		existing.setRole(update.getRole());

		existing.setUsername(update.getUsername());

		this.userCrud.save(existing);

	}

	@Override
	@Transactional(readOnly = true)
	public List<UserBoundary> getAllUsers() {
		return ((List<UserEntity>) userCrud.findAll()).stream().map(entity -> {
			UserBoundary boundary = new UserBoundary();
			UserIdBoundary userId = new UserIdBoundary();
			userId.setEmail(entity.getEmail());
			userId.setSystemID(entity.getSystemID());
			boundary.setUserId(userId);
			boundary.setRole(entity.getRole());
			boundary.setUsername(entity.getUsername());
			boundary.setAvatar(entity.getAvatar());
			return boundary;
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAllUsers() {
		userCrud.deleteAll();
	}
}
