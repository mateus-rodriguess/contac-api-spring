package com.contact.api.controller;

import com.contact.api.dto.response.ContactResponseDto;
import com.contact.api.model.Contact;
import com.contact.api.repository.ContactRepository;
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
    private ContactRepository repository;

    @PostMapping("/contact")
    public Contact contactCreate(@RequestBody Contact contact){
        return (Contact) repository.save(contact);
    }

    @GetMapping("/contact")
    public Page<Contact> contactList(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                     @RequestParam(defaultValue = "5") final Integer size
        ){
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        return repository.findAll(pageRequest);

    }

    @GetMapping("/contact/{uuid}")
    public Object contactByUuid(@PathVariable UUID uuid){
        @NotNull Optional<Contact> contactExist = repository.findById(uuid);
        if(contactExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ContactResponseDto("not found"));
        }
        return repository.findById(uuid);
    }
    @DeleteMapping("/contact/{uuid}")
    public ResponseEntity<Object> contactDelete(@PathVariable UUID uuid){
        @NotNull Optional<Contact> contactExist = repository.findById(uuid);
        if(contactExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg': 'not found'}");
        }
         repository.deleteById(uuid);
         return ResponseEntity.status(HttpStatus.OK).body("{'msg': 'delete'}");
    }
    @PatchMapping("/contact/{uuid}")
    public Object contactPath(@RequestBody  Contact contact, @PathVariable UUID uuid){
        @NotNull Optional<Contact> contactUpdate = repository.findById(uuid);
        if (contactUpdate.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ContactResponseDto("not found"));
        }
        return repository.save(contact);
    }
    @GetMapping("/contact/count")
    public Object contactCount(){
        return repository.count();
    }
}
