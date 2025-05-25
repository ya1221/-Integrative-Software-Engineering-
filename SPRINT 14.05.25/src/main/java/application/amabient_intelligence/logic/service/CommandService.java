package application.amabient_intelligence.logic.service;

import java.util.List;

import application.amabient_intelligence.logic.boundary.CommandBoundary;

public interface CommandService {
	public List<CommandBoundary> InvokeCommand(CommandBoundary command);
	
	public List<CommandBoundary> getAllCommandsHistory();
	
	public void deleteAllCommands();
}