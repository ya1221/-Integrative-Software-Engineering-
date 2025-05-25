package demo.entity;

import java.util.Date;
import java.util.Map;

import org.springframework.data.keyvalue.annotation.KeySpace;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;

@KeySpace("command")
public class CommandEntity {
	@Id
	private CommandIdEntity id;
	private Date invocationTimestamp;
	private String command;
	private TargetObjectEntity targetObject;
	private UserIdEntity invokedBy;
	private Map<String, Object> commandAttributes;

	public CommandEntity() {
	}

	public CommandEntity(CommandIdEntity id, Date invocationTimestamp, String command, TargetObjectEntity targetObject,
			UserIdEntity invokedBy, Map<String, Object> commandAttributes) {
		super();
		this.id = id;
		this.invocationTimestamp = invocationTimestamp;
		this.command = command;
		this.targetObject = targetObject;
		this.invokedBy = invokedBy;
		this.commandAttributes = commandAttributes;
	}

	public CommandIdEntity getId() {
		return id;
	}

	public void setId(CommandIdEntity id) {
		this.id = id;
	}

	public Date getInvocationTimestamp() {
		return invocationTimestamp;
	}

	public void setInvocationTimestamp(Date invocationTimestamp) {
		this.invocationTimestamp = invocationTimestamp;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public TargetObjectEntity getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(TargetObjectEntity targetObject) {
		this.targetObject = targetObject;
	}

	public UserIdEntity getInvokedBy() {
		return invokedBy;
	}

	public void setInvokedBy(UserIdEntity invokedBy) {
		this.invokedBy = invokedBy;
	}

	public Map<String, Object> getCommandAttributes() {
		return commandAttributes;
	}

	public void setCommandAttributes(Map<String, Object> commandAttributes) {
		this.commandAttributes = commandAttributes;
	}

	@Override
	public String toString() {
		return "CommandEntity [id=" + id + ", invocationTimestamp=" + invocationTimestamp + ", command=" + command
				+ ", targetObject=" + targetObject + ", invokedBy=" + invokedBy + ", commandAttributes="
				+ commandAttributes + "]";
	}
}
