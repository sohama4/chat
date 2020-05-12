package org.sohama4.chat.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
  private final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

  @RequestMapping("/register")
  public String home() {
    LOGGER.info("Hello!");
    return "Hello Docker World";
  }
}
