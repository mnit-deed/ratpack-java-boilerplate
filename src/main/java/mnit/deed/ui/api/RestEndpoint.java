package mnit.deed.ui.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.server.RatpackServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.exec.Promise;
import ratpack.health.HealthCheck;
import ratpack.health.HealthCheckHandler;
import ratpack.server.RatpackServer;

public class RestEndpoint {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestEndpoint.class);
  public static void main(String[] args) throws Exception {
    LOGGER.info("Initiating REST endpoint!");
    RatpackServer.start(spec -> spec
      .registryOf(registry -> registry
        .add(HealthCheck.of("status", registrySpec ->
          Promise.value(HealthCheck.Result.healthy("PASSED"))
        ))
      )
      .handlers(chain -> chain
        .get("health/:name?", new HealthCheckHandler())
        // .all(ctx -> ctx.render("root handler!"))
      )
    );
  }
}
