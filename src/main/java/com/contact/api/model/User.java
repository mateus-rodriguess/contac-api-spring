package com.contact.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", length = 30, unique = true)
    @NotBlank(message = "Username cannot be empty")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$",
            message = "username must be of 4 to 20 length with no special characters")
    private String username;

    @Column(name = "email", unique = true)
    @NotBlank(message = "email cannot be empty")
    @NotNull
    @Email
    private String email;

    @Column(name = "password")
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,255}$",
            message = "password must be min 4 and max 255 length containing 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Contact> contact;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Profile profile;



}
