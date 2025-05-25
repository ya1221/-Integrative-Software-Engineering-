package application.amabient_intelligence.presatation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import application.amabient_intelligence.logic.boundary.CommandBoundary;
import application.amabient_intelligence.logic.service.CommandService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = { "/ambient-intelligence" })
public class CommandController {

	private final CommandService commandService;

	public CommandController(CommandService commandService) {
		this.commandService = commandService;
	}

	@PostMapping(path = { "/commands" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CommandBoundary> InvokeCommand(@RequestBody CommandBoundary command) {
		return commandService.InvokeCommand(command);
	}

	@GetMapping(path = { "/admin/commands" })
	public List<CommandBoundary> exportAllCommands() {
		return commandService.getAllCommandsHistory();
	}

	@DeleteMapping(path = { "/admin/commands" })
	public void deleteAllCommands() {
		commandService.deleteAllCommands();
	}
}
