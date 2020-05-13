package org.sohama4.chat.server.controller;

import org.modelmapper.ModelMapper;
import org.sohama4.chat.server.dto.OnlineRequest;
import org.sohama4.chat.server.dto.OnlineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineController {

  @Autowired
  private ModelMapper mapper;

  @PostMapping("/online")
  public ResponseEntity<OnlineResponse> online(@RequestBody OnlineRequest request) {
    return ResponseEntity.ok(mapper.map(request, OnlineResponse.class));
  }
}
