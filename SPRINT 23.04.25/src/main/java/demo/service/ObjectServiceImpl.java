package demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import demo.boundary.HumiditySensorBoundary;
import demo.boundary.ObjectBoundary;
import demo.boundary.ObjectIdBoundary;
import demo.boundary.SensorBoundary;
import demo.boundary.TemperatureSensorBoundary;
import demo.entity.CommandIdEntity;
import demo.entity.HumiditySensorEntity;
import demo.entity.ObjectEntity;
import demo.entity.ObjectIdEntity;
import demo.entity.SensorEntity;
import demo.entity.TemperatureSensorEntity;

@Service
public class ObjectServiceImpl implements ObjectService {

	private AtomicLong idEnumerator;
	private final ObjectCrud objectCrud;

	@Value("${spring.application.name}")
	private String systemID;

	public ObjectServiceImpl(ObjectCrud objectCrud) {
		super();
		this.objectCrud = objectCrud;
		this.idEnumerator = new AtomicLong(1L);
	}

	@Override
	public ObjectBoundary createObject(ObjectBoundary boundary) {
		ObjectEntity entity = boundary.toEntity();
		entity.setId(new ObjectIdEntity(idEnumerator.getAndIncrement(), systemID));
		entity.setCreationTimestamp(new Date());
		return new ObjectBoundary(this.objectCrud.save(entity));
	}

	@Override
	public void updateObject(String id, ObjectBoundary update) {
		ObjectEntity existing = this.objectCrud.findById(new ObjectIdEntity(Long.parseLong(id), systemID))
				.orElseThrow(() -> new RuntimeException("Could not find object by id: " + id));

		if (update.getType() != null) {
			existing.setType(update.getType());
		}

		if (update.getAlias() != null) {
			existing.setAlias(update.getAlias());
		}

		if (update.getStatus() != null) {
			existing.setStatus(update.getStatus());
		}

		if (update.getType() != null) {
			existing.setType(update.getType());
		}

		// no need to check if null since it is boolean and not Boolean
		existing.setActive(update.isActive());

		// no need to update creation time and created by

		if (update.getObjectDetails() != null) {
			existing.setObjectDetails(update.getObjectDetails());
		}

		// If it’s a sensor boundary — update sensor fields
		if (update instanceof SensorBoundary sensorUpdate && existing instanceof SensorEntity sensorEntity) {
			if (sensorUpdate.getLastMeasurement() != null) {
				sensorEntity.setLastMeasurement(sensorUpdate.getLastMeasurement());
			}
			if (sensorUpdate.getUnit() != null) {
				sensorEntity.setUnit(sensorUpdate.getUnit());
			}
		}

		// If it’s a temperature sensor — update temperature field
		if (update instanceof TemperatureSensorBoundary tempUpdate
				&& existing instanceof TemperatureSensorEntity tempEntity) {
			tempEntity.setTemperature(tempUpdate.getTemperature());
		}

		// If it’s a humidity sensor — update humidity field
		if (update instanceof HumiditySensorBoundary humidityUpdate
				&& existing instanceof HumiditySensorEntity humidityEntity) {
			humidityEntity.setHumidity(humidityUpdate.getHumidity());
		}

		this.objectCrud.save(existing);
	}

	@Override
	public Optional<ObjectBoundary> getSingleInstance(String id) {
		return this.objectCrud.findById(new ObjectIdEntity(Long.parseLong(id), systemID)).map(ObjectBoundary::new);
	}

	@Override
	public List<ObjectBoundary> getAllObjects() {
		return StreamSupport.stream(this.objectCrud.findAll().spliterator(), false).map(ObjectBoundary::new).toList();
	}

}
