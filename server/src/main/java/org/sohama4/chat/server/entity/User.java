package org.sohama4.chat.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class User {
  @Id
  private UUID id = UUID.randomUUID();
  private String name;
  private String email;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
