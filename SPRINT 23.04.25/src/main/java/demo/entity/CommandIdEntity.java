package demo.entity;

import org.springframework.data.annotation.Id;


public class CommandIdEntity {
	@Id private Long commandId;
	private String systemID;
	
	public CommandIdEntity() {
	}
	
	public CommandIdEntity(Long commandId, String systemID) {
		super();
		this.commandId = commandId;
		this.systemID = systemID;
	}

	public Long getCommandId() {
		return commandId;
	}

	public void setCommandId(Long commandId) {
		this.commandId = commandId;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	@Override
	public String toString() {
		return "CommandIdEntity [commandId=" + commandId + ", systemID=" + systemID + "]";
	}
}
