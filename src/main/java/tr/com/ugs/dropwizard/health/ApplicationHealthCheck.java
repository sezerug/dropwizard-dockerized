package tr.com.ugs.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by usezer on 20.10.2016.
 */
public class ApplicationHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
