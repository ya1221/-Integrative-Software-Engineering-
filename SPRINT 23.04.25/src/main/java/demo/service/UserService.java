package demo.service;

import java.util.Optional;

import demo.boundary.NewUserBoundary;
import demo.boundary.UserBoundary;

public interface UserService {
	public UserBoundary createUser(NewUserBoundary input);

	public Optional<UserBoundary> getUser(String systemId, String email);

	public void updateUser(String id, String email, UserBoundary update);
}
