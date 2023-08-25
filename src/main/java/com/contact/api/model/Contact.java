package com.contact.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.RegExp;

import java.util.UUID;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 255)
    @NotBlank(message = "Name cannot be empty")
    @NotNull
    private String name;

    @Column(name = "telephone_number", length = 15)
    @NotBlank(message = "Telephone number cannot be empty")
    @NotNull
    private String telephoneNumber;

}
