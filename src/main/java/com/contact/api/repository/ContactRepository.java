package com.contact.api.repository;

import com.contact.api.model.Contact;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, UUID> {

    Object count();

    Object save(Contact contact);

    void deleteById(UUID uuid);

    Optional<Contact> findById(UUID uuid);

    Boolean existsById(UUID uuid);
}
