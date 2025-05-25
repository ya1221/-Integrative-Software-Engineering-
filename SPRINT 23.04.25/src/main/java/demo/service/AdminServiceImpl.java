package demo.service;

import demo.boundary.UserBoundary;
import demo.boundary.CommandBoundary;
import demo.boundary.UserIdBoundary;
import demo.entity.CommandEntity;
import demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

	private final UserCrud userCrud;
	private final CommandCrud commandCrud;
	private final ObjectCrud objectCrud;

	public AdminServiceImpl(UserCrud userCrud, CommandCrud commandCrud, ObjectCrud objectCrud) {
		this.userCrud = userCrud;
		this.commandCrud = commandCrud;
		this.objectCrud = objectCrud;
	}

	@Override
	public void deleteAllUsers() {
		userCrud.deleteAll();
	}

	@Override
	public void deleteAllCommands() {
		commandCrud.deleteAll();
	}

	@Override
	public void deleteAllObjects() {
		this.objectCrud.deleteAll();
	}

	@Override
	public List<UserBoundary> getAllUsers() {
		return ((List<UserEntity>) userCrud.findAll()).stream().map(entity -> {
			UserBoundary boundary = new UserBoundary();
			UserIdBoundary userId = new UserIdBoundary();
			userId.setEmail(entity.getUserId().getEmail());
			userId.setSystemId(entity.getUserId().getSystemId());
			boundary.setUserId(userId);
			boundary.setRole(entity.getRole());
			boundary.setUsername(entity.getUsername());
			boundary.setAvatar(entity.getAvatar());
			return boundary;
		}).collect(Collectors.toList());
	}

	@Override
	public List<CommandBoundary> getAllCommands() {
		return ((List<CommandEntity>) commandCrud.findAll()).stream().map(CommandBoundary::new)
				.collect(Collectors.toList());
	}

}