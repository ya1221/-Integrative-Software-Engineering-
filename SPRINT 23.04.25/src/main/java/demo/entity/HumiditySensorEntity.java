package demo.entity;

import java.util.Date;
import java.util.Map;

public class HumiditySensorEntity extends SensorEntity{
	private double humidity;
	
	public HumiditySensorEntity() {
		this.humidity = 0;
	}


	public HumiditySensorEntity(ObjectIdEntity idEntity, String type, String alias, String status, boolean active,
			Date creationTimestamp, CreatedByEntity createdBy, Map<String, Object> objectDetails, Date lastMeasurement,
			String unit, double humidity) {
		super(idEntity ,type, alias, status, active, creationTimestamp, createdBy, objectDetails, lastMeasurement, unit);
		this.humidity = humidity;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	
}
