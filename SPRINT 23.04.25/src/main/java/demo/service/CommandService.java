package demo.service;

import java.util.List;

import demo.boundary.CommandBoundary;

public interface CommandService {
	public List<CommandBoundary> InvokeCommand(CommandBoundary command);
}