package pl.luckit.test.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static pl.luckit.test.exception.ExceptionMessageEnum.*;

@ControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(value = InvalidInputValueException.class)
    public ResponseEntity<Object> invalidInputValueException(InvalidInputValueException e) {
        LOG.error(INVALID_INPUT_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(INVALID_INPUT_MESSAGE_PAGE.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOG.error(INVALID_INPUT_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(INVALID_INPUT_MESSAGE_PAGE.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> applicationException(Exception e) {
        LOG.error(GENERAL_EXCEPTION_MESSAGE.getMessage(), e);
        return new ResponseEntity<>(GENERAL_EXCEPTION_MESSAGE_PAGE.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
