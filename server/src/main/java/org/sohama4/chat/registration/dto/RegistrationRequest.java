package org.sohama4.chat.registration.dto;

import javax.validation.constraints.Email;

public class RegistrationRequest {
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Email private String email;
  private String name;

  @Override
  public String toString() {
    return "RegistrationRequest{" + "email='" + email + '\'' + ", name='" + name + '\'' + '}';
  }
}
