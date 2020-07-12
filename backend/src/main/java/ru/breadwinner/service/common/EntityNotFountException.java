package ru.breadwinner.service.common;

public class EntityNotFountException extends RuntimeException {

    public EntityNotFountException(String message, Object... args) {
        super(String.format(message, args));
    }
}
