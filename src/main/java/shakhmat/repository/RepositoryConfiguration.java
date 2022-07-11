package shakhmat.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "repository")
public class RepositoryConfiguration {

  private String ouverturePath;

  public String getOuverturePath() {
    return ouverturePath;
  }

  public void setOuverturePath(String ouverturePath) {
    this.ouverturePath = ouverturePath;
  }

}
