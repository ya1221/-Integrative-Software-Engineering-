package application.amabient_intelligence.logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1487178726665525952L;
	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(Exception cause) {
		super (cause);
	}
	
	public NotFoundException(String message, Exception cause) {
		super(message, cause);
	}
}

