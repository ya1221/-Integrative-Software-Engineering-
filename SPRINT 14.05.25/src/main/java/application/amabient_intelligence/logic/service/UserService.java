package application.amabient_intelligence.logic.service;

import java.util.List;

import application.amabient_intelligence.logic.boundary.UserBoundary;

public interface UserService {
	public UserBoundary createUser(UserBoundary user);

	public UserBoundary login(String systemId, String userEmail);

	public void updateUser(String systemId, String userEmail, UserBoundary update);

	public List<UserBoundary> getAllUsers();

	public void deleteAllUsers();
}
