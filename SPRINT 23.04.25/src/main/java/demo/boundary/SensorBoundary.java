package demo.boundary;

import java.util.Date;
import java.util.Map;

import demo.entity.ObjectEntity;
import demo.entity.SensorEntity;

public abstract class SensorBoundary extends ObjectBoundary {
	
 	private Date lastMeasurement;
    private String unit;
    
    public SensorBoundary() {
    	this.lastMeasurement = null;
    	this.unit = null;
    }
    public SensorBoundary(ObjectIdBoundary id, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByBoundary createdBy, Map<String, Object> objectDetails, Date lastMeasurement,
			String unit) {
		super(id, type, alias, status, active, creationTimestamp, createdBy, objectDetails);
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

	public SensorBoundary(SensorEntity sensorEntity) {
		this.lastMeasurement = sensorEntity.getLastMeasurement();
		this.unit = sensorEntity.getUnit();
	}
	
	protected void copyBaseFields(SensorEntity sensorEntity) {
		sensorEntity.setLastMeasurement(this.getLastMeasurement());
	    sensorEntity.setUnit(this.getUnit());
	}

}
