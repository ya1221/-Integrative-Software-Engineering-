package application.amabient_intelligence.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class IdGenerator {
	@Id @GeneratedValue private Long id;

	public IdGenerator() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "{id:" + id + "}";
	}

}
