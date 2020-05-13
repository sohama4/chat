package org.sohama4.chat.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
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

  @Bean
  public ModelMapper getModelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    return mapper;
  }

  @NotNull
  private CassandraConfiguration cassandra;
}
