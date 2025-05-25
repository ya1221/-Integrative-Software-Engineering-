package application.amabient_intelligence.logic.boundary;

import java.util.Date;
import java.util.Map;

public class CommandBoundary {
	private CommandIdBoundary id;
	private String command;
	private TargetObjectBoundary targetObject;
	private Date invocationTimestamp;
	private UserIdBoundary invokedBy;
	private Map<String, Object> commandAttributes;

	public CommandBoundary() {
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

	@Override
	public String toString() {
		return "CommandBoundary [id=" + id + ", command=" + command + ", targetObject=" + targetObject
				+ ", invocationTimestamp=" + invocationTimestamp + ", invokedBy=" + invokedBy + ", commandAttributes="
				+ commandAttributes + "]";
	}

}
