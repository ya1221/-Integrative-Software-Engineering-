package demo.entity;

import java.util.Date;
import java.util.Map;


public abstract class SensorEntity extends ObjectEntity{
	private Date lastMeasurement;
    private String unit;
    
    public SensorEntity() {
    	this.lastMeasurement = null;
    	this.unit = null;
    }
  
    public SensorEntity(ObjectIdEntity idEntity ,String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByEntity createdBy, Map<String, Object> objectDetails, Date lastMeasurement,
			String unit) {
		super(idEntity ,type, alias, status, active, creationTimestamp, createdBy, objectDetails);
		this.lastMeasurement = lastMeasurement;
		this.unit = unit;
	}

	public Date getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(Date lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
