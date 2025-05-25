package demo.boundary;

import java.util.Date;
import java.util.Map;

import demo.entity.HumiditySensorEntity;

public class HumiditySensorBoundary extends SensorBoundary{
	
	private double humidity;
	
	public HumiditySensorBoundary() {
		super();
		this.humidity = 0;
	}
    
	public HumiditySensorBoundary(ObjectIdBoundary id, String type, String alias, String status, boolean active, Date creationTimestamp,
			CreatedByBoundary createdBy, Map<String, Object> objectDetails, Date lastMeasurement, String unit,
			double humidity) {
		super(id, type, alias, status, active, creationTimestamp, createdBy, objectDetails, lastMeasurement, unit);
		this.humidity = humidity;
	}

	public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    
    public HumiditySensorBoundary(HumiditySensorEntity humiditySensorEntity) {
    	 super(humiditySensorEntity); 
    	 this.setHumidity(humiditySensorEntity.getHumidity());
    }
    
    public HumiditySensorEntity toEntity() {
        HumiditySensorEntity humiditySensorEntity = new HumiditySensorEntity();
        super.copyBaseFields(humiditySensorEntity); 
        humiditySensorEntity.setHumidity(this.getHumidity());
        return humiditySensorEntity;
    }
}
