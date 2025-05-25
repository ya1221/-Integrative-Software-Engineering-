package demo.boundary;

import java.util.Date;
import java.util.Map;

import demo.entity.HumiditySensorEntity;
import demo.entity.TemperatureSensorEntity;

public class TemperatureSensorBoundary extends SensorBoundary{
	
	private double temperature;
	
	
	public TemperatureSensorBoundary(ObjectIdBoundary id, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByBoundary createdBy, Map<String, Object> objectDetails, Date lastMeasurement,
			String unit, double temperature) {
		super(id, type, alias, status, active, creationTimestamp, createdBy, objectDetails, lastMeasurement, unit);
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public TemperatureSensorBoundary(TemperatureSensorEntity temperatureSensorEntity) {
		super(temperatureSensorEntity); 
   	    this.setTemperature(temperatureSensorEntity.getTemperature());
   }
   
   public TemperatureSensorEntity toEntity() {
	   TemperatureSensorEntity temperatureSensorEntity = new TemperatureSensorEntity();
       super.copyBaseFields(temperatureSensorEntity); 
       temperatureSensorEntity.setTemperature(this.getTemperature());
       return temperatureSensorEntity;
   }
}
