package demo.boundary;

public class TargetObjectBoundary {
	private ObjectIdBoundary id;

	public TargetObjectBoundary() {

	}

	public TargetObjectBoundary(ObjectIdBoundary id) {
		super();
		this.id = id;
	}

	public ObjectIdBoundary getId() {
		return id;
	}

	public void setId(ObjectIdBoundary id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TargetObjectBoundary [id=" + id + "]";
	}

}
