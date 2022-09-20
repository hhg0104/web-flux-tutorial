package webflux.tutorial.userinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserInfoHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(UserInfoHandler.class);

    public Mono<ServerResponse> getUserInfo(ServerRequest req) {
        LOGGER.info("Fetching the user info...");

        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(fromValue("Hello World"));
    }
}