package org.sohama4.chat.registration.repository;

import org.sohama4.chat.registration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UserRepository extends CrudRepository<User, UUID> {
}
