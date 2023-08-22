package com.contact.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", length = 30, unique = true)
    @NotBlank
    @NotNull
    private String username;

    @Column(name = "email", unique = true)
    @NotNull
    @NotNull
    @Email
    private String email;

    @ManyToOne(cascade = CascadeType.MERGE, optional=false)
    @JoinColumn(name="id_contact",referencedColumnName="id")
    private Contact contact;

}
