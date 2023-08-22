package com.contact.api.controller;

import com.contact.api.model.User;
import com.contact.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Page<User> usersList(@RequestParam(defaultValue = "0") Integer pageNumber,
                                @RequestParam(defaultValue = "100") Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        return userService.userList(pageRequest);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> usersCreate(@Valid @RequestBody User user) {
        return userService.userCreate(user);
    }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<Object> userByUuid(@PathVariable UUID uuid) {
        return userService.userByUuid(uuid);
    }

    @PatchMapping("/users/{uuid}")
    public ResponseEntity<Object> userUpdate(@PathVariable UUID uuid, @Valid @RequestBody User user) {
        return userService.userUpdate(uuid, user);
    }

    @DeleteMapping("/users/{uuid}")
    public ResponseEntity<Object> userDelete(@PathVariable UUID uuid) {
        return userService.userDelete(uuid);
    }
}
