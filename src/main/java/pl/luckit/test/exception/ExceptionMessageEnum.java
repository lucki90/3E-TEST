package pl.luckit.test.exception;

import lombok.Getter;

public enum ExceptionMessageEnum {

    INVALID_INPUT_MESSAGE_PAGE("Error page: Invalid input values."),
    INVALID_INPUT_MESSAGE("Invalid input values: "),
    GENERAL_EXCEPTION_MESSAGE_PAGE("Error page: Internal server error."),
    GENERAL_EXCEPTION_MESSAGE("Internal server error: "),
    INVALID_PATH_MESSAGE_PAGE("Error page: You have probably entered an incorrect values in URI."),
    INVALID_PATH_MESSAGE("Endpoint '/error' was called.");

    @Getter
    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }
}
