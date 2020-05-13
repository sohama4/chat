package org.sohama4.chat.server.repository;

import org.sohama4.chat.server.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UserRepository extends CrudRepository<User, UUID> {
}
