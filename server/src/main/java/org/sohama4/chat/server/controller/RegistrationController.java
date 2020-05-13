package org.sohama4.chat.server.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohama4.chat.server.dto.registration.RegistrationRequest;
import org.sohama4.chat.server.entity.User;
import org.sohama4.chat.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
  private final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

  @Autowired
  UserRepository userRepository;

  @Autowired
  ModelMapper modelMapper;

  @PostMapping("/register")
  public String register(@RequestBody RegistrationRequest request) {
    LOGGER.info(String.format("Received request: %s", request.toString()));
    User user = modelMapper.map(request, User.class);
    System.out.println(user);
    userRepository.save(user);
    return "Hello Docker World";
  }
}
