package webflux.tutorial.userinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserInfoRouter {

    @Bean
    public RouterFunction<ServerResponse> routeUerInfo(final UserInfoHandler userInfoHandler) {
        return route(GET("/user/{userId}").and(accept(MediaType.TEXT_PLAIN)),
                userInfoHandler::getUserInfo);
    }
}
