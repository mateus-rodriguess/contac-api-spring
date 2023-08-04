package com.contact.api.dto.response;

import lombok.Data;

@Data
public class ContactResponseDto {
    private String message;

    public ContactResponseDto(String message) {
        this.message = message;
    }
}
