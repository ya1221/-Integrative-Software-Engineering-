package demo.entity;

public class TargetObjectEntity {
	private ObjectIdEntity id;

	public TargetObjectEntity() {

	}

	public TargetObjectEntity(ObjectIdEntity id) {
		super();
		this.id = id;
	}

	public ObjectIdEntity getId() {
		return id;
	}

	public void setId(ObjectIdEntity id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TargetObjectEntity [id=" + id + "]";
	}

}
