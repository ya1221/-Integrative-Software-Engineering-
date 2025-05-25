package application.amabient_intelligence.logic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.amabient_intelligence.data.IdGenerator;
import application.amabient_intelligence.data.crud.CommandCrud;
import application.amabient_intelligence.data.crud.IdGeneratorCrud;
import application.amabient_intelligence.data.entity.CommandEntity;
import application.amabient_intelligence.logic.boundary.CommandBoundary;
import application.amabient_intelligence.logic.converter.CommandConverter;
import application.amabient_intelligence.logic.exception.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommandServiceImpl implements CommandService {

	private final CommandCrud commandCrud;
	private IdGeneratorCrud IdGeneratorCrud;
	private CommandConverter commandConverter;

	private String systemID;

	public CommandServiceImpl(CommandCrud commandCrud, IdGeneratorCrud IdGeneratorCrud,
			CommandConverter commandConverter) {
		this.commandCrud = commandCrud;
		this.IdGeneratorCrud = IdGeneratorCrud;
		this.commandConverter = commandConverter;
	}

	@Value("${spring.application.name}")
	public void setSystemID(String systemID) {
		this.systemID = systemID;
		System.err.println("*** " + this.systemID);
	}

	@Override
	@Transactional(readOnly = false) // defualt = not read only
	public List<CommandBoundary> InvokeCommand(CommandBoundary command) {
		if (command.getInvokedBy() == null || command.getInvokedBy().getEmail() == null) {
			throw new InvalidInputException("user email is missing");
		}

		if (command.getCommand() == null)
			throw new InvalidInputException("command is missing");
		if (command.getTargetObject() == null || command.getTargetObject().getId().getObjectId() == null)
			throw new InvalidInputException("target id object is missing");

		CommandEntity entity = commandConverter.toEntity(command);

		IdGenerator tmp = this.IdGeneratorCrud.save(new IdGenerator());

		entity.setCommandId(tmp.getId());
		this.IdGeneratorCrud.delete(tmp);
		entity.setInvocationTimestamp(new Date());

		entity.setSystemID(systemID);
		commandCrud.save(entity);
		return StreamSupport.stream(commandCrud.findAll().spliterator(), false).map(commandConverter::toBoundary)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommandBoundary> getAllCommandsHistory() {
		return ((List<CommandEntity>) commandCrud.findAll()).stream().map(commandConverter::toBoundary)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAllCommands() {
		commandCrud.deleteAll();
	}
}