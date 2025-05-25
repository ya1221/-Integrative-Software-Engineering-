package demo.service;

import demo.boundary.UserBoundary;
import demo.boundary.CommandBoundary;

import java.util.List;

public interface AdminService {
    void deleteAllUsers();
    void deleteAllObjects();
    void deleteAllCommands();
    List<UserBoundary> getAllUsers();
    List<CommandBoundary> getAllCommands();
}