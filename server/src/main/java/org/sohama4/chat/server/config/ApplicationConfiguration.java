package org.sohama4.chat.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties
public class ApplicationConfiguration {
  public CassandraConfiguration getCassandra() {
    return cassandra;
  }

  public void setCassandra(CassandraConfiguration cassandra) {
    this.cassandra = cassandra;
  }

  @NotNull
  private CassandraConfiguration cassandra;
}
