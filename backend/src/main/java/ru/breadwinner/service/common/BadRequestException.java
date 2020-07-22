package ru.breadwinner.service.common;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String errorMessage, Object... args) {
        super(String.format(errorMessage, args));
    }
}
