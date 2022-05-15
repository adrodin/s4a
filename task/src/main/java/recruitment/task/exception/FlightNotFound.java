package recruitment.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Flight not found")
public class FlightNotFound extends RuntimeException{
    public FlightNotFound() {
        super();
    }
}
