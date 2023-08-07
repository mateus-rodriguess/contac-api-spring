package com.contact.api.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private String message;

    public UserResponseDto(String message) {
        this.message = message;
    }
}
