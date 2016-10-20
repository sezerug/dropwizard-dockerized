package tr.com.ugs.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import tr.com.ugs.dropwizard.config.ApplicationConfig;
import tr.com.ugs.dropwizard.health.ApplicationHealthCheck;
import tr.com.ugs.dropwizard.resources.AdminResource;
import tr.com.ugs.dropwizard.resources.UserResource;

/**
 * Created by usezer on 20.10.2016.
 */
public class DropwizardApplication extends Application<ApplicationConfig> {

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public void run(ApplicationConfig config, Environment environment) throws Exception {
        environment.healthChecks().register("ApplicationHealthCheck", new ApplicationHealthCheck());
        environment.jersey().register(new AdminResource(config));
        environment.jersey().register(new UserResource());
    }
}
