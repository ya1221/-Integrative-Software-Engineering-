package demo.boundary;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import demo.entity.CommandEntity;
import demo.entity.ObjectIdEntity;
import demo.entity.TargetObjectEntity;
import demo.entity.UserIdEntity;

public class CommandBoundary {
	private CommandIdBoundary id;
	private String command;
	private TargetObjectBoundary targetObject;
	private Date invocationTimestamp;
	private UserIdBoundary invokedBy;
	private Map<String, Object> commandAttributes;

	public CommandBoundary() {
	}

	public CommandBoundary(CommandEntity entity) {
		if (entity != null) {
			if (entity.getId() != null) {
				this.id = new CommandIdBoundary(entity.getId().getCommandId().toString(), entity.getId().getSystemID());
			}
			this.command = entity.getCommand();
			if (entity.getTargetObject() != null) {
				this.targetObject = new TargetObjectBoundary(
						new ObjectIdBoundary(entity.getTargetObject().getId().getSystemID(),
								entity.getTargetObject().getId().getObjectId().toString()));
			}
			this.invocationTimestamp = entity.getInvocationTimestamp();
			if (entity.getInvokedBy() != null) {
				this.invokedBy = new UserIdBoundary(entity.getInvokedBy().getEmail(),
						entity.getInvokedBy().getSystemId());
			}
			this.commandAttributes = entity.getCommandAttributes();
		}
	}

	public CommandIdBoundary getId() {
		return id;
	}

	public void setId(CommandIdBoundary id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public TargetObjectBoundary getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(TargetObjectBoundary targetObject) {
		this.targetObject = targetObject;
	}

	public Date getInvocationTimestamp() {
		return invocationTimestamp;
	}

	public void setInvocationTimestamp(Date invocationTimestamp) {
		this.invocationTimestamp = invocationTimestamp;
	}

	public UserIdBoundary getInvokedBy() {
		return invokedBy;
	}

	public void setInvokedBy(UserIdBoundary invokedBy) {
		this.invokedBy = invokedBy;
	}

	public Map<String, Object> getCommandAttributes() {
		return commandAttributes;
	}

	public void setCommandAttributes(Map<String, Object> commandAttributes) {
		this.commandAttributes = commandAttributes;
	}

	public CommandEntity toEntity() {
		CommandEntity entity = new CommandEntity();

		entity.setCommand(this.getCommand());

		if (this.getTargetObject() != null) {
			if (!this.getTargetObject().getId().getObjectId().equals("string")) {
				entity.setTargetObject(new TargetObjectEntity(
						new ObjectIdEntity(Long.parseLong(this.getTargetObject().getId().getObjectId()),
								this.getTargetObject().getId().getSystemID())));
			} else {
				entity.setTargetObject(new TargetObjectEntity(
						new ObjectIdEntity((long) 0, this.getTargetObject().getId().getSystemID())));
			}
		}

		if (this.getInvokedBy() != null) {
			entity.setInvokedBy(new UserIdEntity(this.getInvokedBy().getEmail(), this.getInvokedBy().getSystemId()));
		}

		entity.setInvocationTimestamp(this.getInvocationTimestamp());

		entity.setCommandAttributes(this.getCommandAttributes());

		return entity;
	}

	@Override
	public String toString() {
		return "CommandBoundary [id=" + id + ", command=" + command + ", targetObject=" + targetObject
				+ ", invocationTimestamp=" + invocationTimestamp + ", invokedBy=" + invokedBy + ", commandAttributes="
				+ commandAttributes + "]";
	}

}
