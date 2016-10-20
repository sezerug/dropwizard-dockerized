package tr.com.ugs.dropwizard.config;

import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

/**
 * Created by usezer on 20.10.2016.
 */
public class ApplicationConfig extends Configuration {

    @NotNull
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
