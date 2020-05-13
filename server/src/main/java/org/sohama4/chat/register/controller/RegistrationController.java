package org.sohama4.chat.register.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohama4.chat.register.dto.RegistrationRequest;
import org.sohama4.chat.register.dto.RegistrationResponse;
import org.sohama4.chat.register.entity.User;
import org.sohama4.chat.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
public class RegistrationController {
  private final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

  @Autowired
  UserRepository userRepository;

  @Autowired
  ModelMapper modelMapper;

  @PostMapping("/register")
  public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
    LOGGER.info(String.format("Received request: %s", request.toString()));
    User user = modelMapper.map(request, User.class);
    System.out.println(user);
    userRepository.save(user);

    Iterable<User> users = userRepository.findAll();
    LOGGER.info(
        String.format(
            "Count of users: %d",
            StreamSupport.stream(users.spliterator(), false).count()
        )
    );
    return ResponseEntity.ok(modelMapper.map(user, RegistrationResponse.class));
  }
}
