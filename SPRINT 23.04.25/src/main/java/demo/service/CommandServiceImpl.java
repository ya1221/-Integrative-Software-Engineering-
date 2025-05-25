package demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import demo.boundary.CommandBoundary;
import demo.controller.CommandController;
import demo.entity.CommandEntity;
import demo.entity.CommandIdEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommandServiceImpl implements CommandService {

	private final CommandCrud commandCrud;
	private AtomicLong idEnumerator;

	@Value("${spring.application.name}")
	private String systemID;

	public CommandServiceImpl(CommandCrud commandCrud) {
		this.commandCrud = commandCrud;
		this.idEnumerator = new AtomicLong(1L);
	}

	@Override
	public List<CommandBoundary> InvokeCommand(CommandBoundary command) {
		CommandEntity entity = command.toEntity();

		entity.setId(new CommandIdEntity(idEnumerator.getAndIncrement(), systemID));
		entity.setInvocationTimestamp(new Date());
		commandCrud.save(entity);
		return StreamSupport.stream(commandCrud.findAll().spliterator(), false).map(CommandBoundary::new)
				.collect(Collectors.toList());
	}
}