package com.contact.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    @NotBlank(message = "FirstName cannot be empty")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "LastName cannot be empty")
    @NotNull
    private String lastName;


}
