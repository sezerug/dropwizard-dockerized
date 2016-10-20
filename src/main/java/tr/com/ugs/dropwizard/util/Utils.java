package tr.com.ugs.dropwizard.util;

import java.util.UUID;

/**
 * Created by usezer on 20.10.2016.
 */
public class Utils {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
