package application.amabient_intelligence.data.entity;

import java.util.Date;
import java.util.Map;

import application.amabient_intelligence.data.MapToJsonConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;


@Entity
@Table(name = "COMMAND")
public class CommandEntity {
	@Id
	private Long commandId;
	private String systemID;
	@Temporal(TemporalType.TIMESTAMP)
	private Date invocationTimestamp;
	private String command;
//	private TargetObjectEntity targetObject;
	private Long objectId;
//	private UserIdEntity invokedBy; 
	private String email;
	@Convert(converter = MapToJsonConverter.class)
	private Map<String, Object> commandAttributes;

	public CommandEntity() {
	}

	public CommandEntity(Long commandId, String systemID, Date invocationTimestamp, String command, Long objectId,
			String email, Map<String, Object> commandAttributes) {
		super();
		this.commandId = commandId;
		this.systemID = systemID;
		this.invocationTimestamp = invocationTimestamp;
		this.command = command;
		this.objectId = objectId;
		this.email = email;
		this.commandAttributes = commandAttributes;
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

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getCommandAttributes() {
		return commandAttributes;
	}

	public void setCommandAttributes(Map<String, Object> commandAttributes) {
		this.commandAttributes = commandAttributes;
	}

	@Override
	public String toString() {
		return "CommandEntity [commandId=" + commandId + ", systemID=" + systemID + ", invocationTimestamp="
				+ invocationTimestamp + ", command=" + command + ", objectId=" + objectId + ", email=" + email
				+ ", commandAttributes=" + commandAttributes + "]";
	}
}
