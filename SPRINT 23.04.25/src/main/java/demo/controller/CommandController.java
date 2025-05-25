package demo.controller;

import org.springframework.web.bind.annotation.*;

import demo.boundary.CommandBoundary;
import demo.service.CommandService;

import java.util.List;

@RestController
@RequestMapping(path = { "/ambient-intelligence/commands" })
public class CommandController {

	private final CommandService commandService;

	public CommandController(CommandService commandService) {
		this.commandService = commandService;
	}

	@PostMapping
	public List<CommandBoundary> InvokeCommand(@RequestBody CommandBoundary command) {
		return commandService.InvokeCommand(command);
	}
}
