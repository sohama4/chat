package org.sohama4.chat.server.database;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohama4.chat.server.config.ApplicationConfiguration;
import org.sohama4.chat.server.config.CassandraConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CassandraConnectionFactory implements DatabaseConnectionFactory {
  private Cluster cluster;
  private Session session;
  private final Logger LOGGER = LoggerFactory.getLogger(CassandraConnectionFactory.class);

  @Autowired
  private ApplicationConfiguration configuration;

  private void connect() {
    CassandraConfiguration cassandraConfiguration = configuration.getCassandra();
    LOGGER.info(
        String.format(
            "Setting up connection to: %s:%d",
            cassandraConfiguration.getHostname(),
            cassandraConfiguration.getPort()
        )
    );

    Cluster.Builder builder = Cluster
        .builder()
        .addContactPoint(cassandraConfiguration.getHostname())
        .withPort(cassandraConfiguration.getPort());

    if (!cassandraConfiguration.getEnableMetrics()) {
      builder.withoutMetrics();
    }
    if (!cassandraConfiguration.getEnableJMXReporting()) {
      builder.withoutJMXReporting();
    }
    this.cluster = builder.build();
    this.session = this.cluster.connect();
  }

  @Bean
  public Session getSession() {
    if (this.session == null) {
      this.connect();
    }
    return session;
  }

  public void close() {
    session.close();
    cluster.close();
  }
}
