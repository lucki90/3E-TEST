package pl.luckit.test.exception;

import static pl.luckit.test.exception.ExceptionMessageEnum.INVALID_INPUT_MESSAGE;

public class InvalidInputValueException extends Exception {

    public InvalidInputValueException() {
        super(INVALID_INPUT_MESSAGE.getMessage());
    }
}
