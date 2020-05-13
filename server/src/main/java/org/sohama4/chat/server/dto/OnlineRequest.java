package org.sohama4.chat.server.dto;

import java.util.UUID;

public class OnlineRequest {
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
