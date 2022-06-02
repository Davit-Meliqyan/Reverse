package am.reverse.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String s) {
        super(s);
    }
}
