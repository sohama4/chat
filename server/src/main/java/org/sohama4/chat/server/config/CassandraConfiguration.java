package org.sohama4.chat.server.config;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class CassandraConfiguration {
  @NotNull
  private String hostname;

  @NotNull
  private Integer port;

  @NotNull
  private Boolean enableMetrics;

  @NotNull
  private Boolean enableJMXReporting;

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
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
}
