package org.sohama4.chat.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohama4.chat.server.dto.registration.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
  private final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

  @PostMapping("/register")
  public String register(@RequestBody RegistrationRequest request) {
    LOGGER.info(String.format("Received request: %s", request.toString()));
    return "Hello Docker World";
  }
}
