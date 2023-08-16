package com.contact.api.repository;

import com.contact.api.model.Contact;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, UUID> {

    Object count();

    Object save(Contact contact);

    void deleteById(UUID uuid);

    Optional<Contact> findById(UUID uuid);

    Boolean existsById(UUID uuid);

    @Query(value = "select * from contact c where c.name = ?1", nativeQuery = true)
    Page<Contact> findAllName(String name, Pageable pageable);

}
