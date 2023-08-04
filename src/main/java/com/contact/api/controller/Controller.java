package com.contact.api.controller;

import com.contact.api.dto.response.ContactResponseDto;
import com.contact.api.model.Contact;
import com.contact.api.service.ContactService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public Contact contactCreate(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping("/contact")
    public Page<Contact> contactList(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                     @RequestParam(defaultValue = "5") final Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        return contactService.findAll(pageRequest);
    }

    @GetMapping("/contact/{uuid}")
    public Object contactByUuid(@PathVariable UUID uuid) {
        return contactService.findByUuid(uuid);
    }

    @DeleteMapping("/contact/{uuid}")
    public ResponseEntity<Object> contactDelete(@PathVariable UUID uuid) {
        return contactService.deleteByUuid(uuid);
    }

    @PatchMapping("/contact/{uuid}")
    public Object contactPath(@RequestBody Contact contact, @PathVariable UUID uuid) {
        return contactService.patchByUuid(uuid, contact);
    }

}
