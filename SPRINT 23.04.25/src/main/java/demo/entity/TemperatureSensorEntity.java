package demo.entity;

import java.util.Date;
import java.util.Map;

import demo.boundary.CreatedByBoundary;
import demo.boundary.ObjectIdBoundary;

public class TemperatureSensorEntity extends SensorEntity{
	private double temperature;
	
	public TemperatureSensorEntity() {
		this.temperature = 0;
	}
	
	public TemperatureSensorEntity(ObjectIdEntity idEntity, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByEntity createdBy, Map<String, Object> objectDetails, Date lastMeasurement,
			String unit, double temperature) {
		super(idEntity ,type, alias, status, active, creationTimestamp, createdBy, objectDetails, lastMeasurement, unit);
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
