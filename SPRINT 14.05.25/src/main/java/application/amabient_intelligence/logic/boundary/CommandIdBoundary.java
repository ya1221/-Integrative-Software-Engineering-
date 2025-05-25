package application.amabient_intelligence.logic.boundary;

public class CommandIdBoundary {
	private String commandId;
	private String systemID;

	public CommandIdBoundary() {
	}

	public CommandIdBoundary(String id, String systemId) {
		super();
		this.commandId = id;
		this.systemID = systemId;
	}

	public String getSystemId() {
		return systemID;
	}

	public void setSystemId(String systemId) {
		this.systemID = systemId;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	@Override
	public String toString() {
		return "CommandIdBoundary [commandId=" + commandId + ", systemID=" + systemID + "]";
	}

}
