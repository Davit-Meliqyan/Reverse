package am.reverse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends RuntimeException {

    private final String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
