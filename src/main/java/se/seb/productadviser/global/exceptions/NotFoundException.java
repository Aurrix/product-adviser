package se.seb.productadviser.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    code = HttpStatus.NOT_FOUND,
    reason = "Resource with specified ID could not be found!")
public class NotFoundException extends RuntimeException {

}
