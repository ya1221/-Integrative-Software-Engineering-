package application.amabient_intelligence.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import application.amabient_intelligence.data.MapToJsonConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "OBJECTS")
public class ObjectEntity {

	
//	private ObjectIdEntity id;
	@Id
	private Long objectId;
	private String systemID;
	
	private String type;
	private String alias;
	private String status;
	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTimestamp;

//	private CreatedByEntity createdBy;
	private String email;
	
	@ManyToMany
	@JoinTable(
	    name = "object_relations",
	    joinColumns = {
	        @JoinColumn(name = "parent_object_id", referencedColumnName = "objectId"),
	        @JoinColumn(name = "parent_system_id", referencedColumnName = "systemId")
	    },
	    inverseJoinColumns = {
	        @JoinColumn(name = "child_object_id", referencedColumnName = "objectId"),
	        @JoinColumn(name = "child_system_id", referencedColumnName = "systemId")
	    }
	)
	private List<ObjectEntity> childrens = new ArrayList<>();

	@ManyToMany(mappedBy = "childrens")
	private List<ObjectEntity> parents = new ArrayList<>();


	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Lob @Convert(converter = MapToJsonConverter.class)
	private Map<String, Object> objectDetails;

	public ObjectEntity() {}

//	public ObjectIdEntity getId() {
//		return id;
//	}
//
//	public void setId(ObjectIdEntity id) {
//		this.id = id;
//	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Map<String, Object> getObjectDetails() {
		return objectDetails;
	}

	public void setObjectDetails(Map<String, Object> objectDetails) {
		this.objectDetails = objectDetails;
	}
	
	public List<ObjectEntity> getChildrens() {
	    return childrens;
	}

	public void setChildrens(List<ObjectEntity> childrens) {
	    this.childrens = childrens;
	}

	public List<ObjectEntity> getParents() {
	    return parents;
	}

	public void setParents(List<ObjectEntity> parents) {
	    this.parents = parents;
	}

	@Override
	public String toString() {
		return "{" +
			"id: " + objectId +
			", systemID: " + systemID +
			", type: " + type +
			", alias: " + alias +
			", status: " + status +
			", active: " + active +
			", creationTimestamp: " + creationTimestamp +
			", email: " + email +
			", objectDetails: " + objectDetails +
			"}";
	}
}
