package db.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7428051251365675318L;

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
