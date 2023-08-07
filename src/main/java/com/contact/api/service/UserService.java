package com.contact.api.service;

import com.contact.api.dto.response.UserResponseDto;
import com.contact.api.model.Contact;
import com.contact.api.model.User;
import com.contact.api.repository.UserRepository;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional()
    public User userCreate(User user) {
        return (User) userRepository.save(user);
    }

    public Page<User> userList(PageRequest page) {
        return userRepository.findAll(page);
    }

    public ResponseEntity<Object> userByUuid(UUID uuid) {
        @NotNull Optional<User> userExists = userRepository.findById(uuid);

        if (userExists.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserResponseDto("Not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(userExists);
    }

    @Transactional
    public ResponseEntity<Object> userUpdate(UUID uuid, User user) {
        @NotNull Optional<User> userExists = userRepository.findById(uuid);

        if (userExists.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserResponseDto("Not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @Transactional
    public ResponseEntity<Object> userDelete(UUID uuid) {
        Boolean userExists = userRepository.existsById(uuid);
        System.out.println(userExists);
        if (!userExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserResponseDto("Not found"));
        }
        userRepository.deleteById(uuid);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");

    }

}
