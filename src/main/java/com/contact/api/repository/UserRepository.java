package com.contact.api.repository;

import com.contact.api.model.Contact;
import com.contact.api.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    Object save(User user);

    Optional<User> findById(UUID uuid);

    Boolean existsById(UUID uuid);

    void deleteById(UUID uuid);

}
