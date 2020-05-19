package org.sohama4.chat.config;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
@ConfigurationProperties(prefix = "cassandra")
public class CassandraConfiguration extends AbstractCassandraConfiguration {
  @NotNull private String hostname;

  @NotNull private Boolean enableMetrics;

  @NotNull private Boolean enableJMXReporting;

  private String keyspace;

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public Boolean getEnableJMXReporting() {
    return enableJMXReporting;
  }

  public void setEnableJMXReporting(Boolean enableJMXReporting) {
    this.enableJMXReporting = enableJMXReporting;
  }

  public Boolean getEnableMetrics() {
    return enableMetrics;
  }

  public void setEnableMetrics(Boolean enableMetrics) {
    this.enableMetrics = enableMetrics;
  }

  public String getKeyspace() {
    return keyspace;
  }

  public void setKeyspace(String keyspace) {
    this.keyspace = keyspace;
  }

  @Override
  protected String getKeyspaceName() {
    return keyspace;
  }

  @Override
  protected String getContactPoints() {
    return hostname;
  }

  @Override
  protected boolean getMetricsEnabled() {
    return enableMetrics;
  }
}
