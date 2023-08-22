package com.contact.api.configuration.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID uuid) {
        super("not found for id: " + String.valueOf(uuid));
    }
}
