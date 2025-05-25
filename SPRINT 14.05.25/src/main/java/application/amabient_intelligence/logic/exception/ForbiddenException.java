package application.amabient_intelligence.logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenException 
	extends RuntimeException {

	private static final long serialVersionUID = 7401529782085579411L;
	
	public ForbiddenException() {
		super();
	}
	
	public ForbiddenException(String message) {
		super(message);
	}
	
	public ForbiddenException(Exception cause) {
		super (cause);
	}
}
	
