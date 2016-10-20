package tr.com.ugs.dropwizard.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.ugs.dropwizard.config.ApplicationConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by usezer on 20.10.2016.
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class AdminResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminResource.class);

    private final ApplicationConfig config;

    public AdminResource(ApplicationConfig config) {
        this.config = config;
    }

    @GET
    @Path("/environment")
    public String getEnvironment() {
        LOGGER.info("Getting environment info.");
        final String environment = config.getEnvironment();
        LOGGER.info("Application is running on {} environment.", environment);
        return environment;
    }
}
