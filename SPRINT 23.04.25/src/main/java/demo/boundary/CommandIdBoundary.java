package demo.boundary;

import demo.entity.CommandIdEntity;

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

	public CommandIdEntity toEntity() {
	    CommandIdEntity entity = new CommandIdEntity();

	    if (this.getCommandId() != null) {
	    	entity.setCommandId(Long.parseLong(this.getCommandId()));
		}else {
			entity.setCommandId(null);
		}
	    
	    entity.setSystemID(this.getSystemId());
	    
	    return entity;
	}
	
	@Override
	public String toString() {
		return "CommandIdBoundary [commandId=" + commandId + ", systemID=" + systemID + "]";
	}
	
	
}
