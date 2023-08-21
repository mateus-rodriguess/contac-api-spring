package com.contact.api.configuration.exception;

import java.util.UUID;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(UUID uuid) {
        super("not found for id: " + String.valueOf(uuid));
    }
}
