package tr.com.ugs.dropwizard.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.ugs.dropwizard.api.User;
import tr.com.ugs.dropwizard.util.Utils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by usezer on 20.10.2016.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private static final Map<String, User> USER_STORE = new HashMap<>();

    @GET
    public Response listAll() {
        LOGGER.info("Getting users.");
        final List<User> userList = USER_STORE.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        LOGGER.info("User list size: {}.", userList.size());
        return Response.ok(userList).build();
    }

    @POST
    public Response addUser(User user) {
        LOGGER.info("Adding new user to store. user: {}", user);
        addToStore(user);
        LOGGER.info("User added to store. user: {}", user);
        return Response.ok(user).build();
    }

    private void addToStore(User user) {
        user.setId(Utils.generateUniqueID());
        USER_STORE.put(user.getUsername(), user);
    }
}
