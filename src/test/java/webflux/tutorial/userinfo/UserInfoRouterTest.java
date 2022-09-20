package webflux.tutorial.userinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@ContextConfiguration(classes = {UserInfoRouter.class, UserInfoHandler.class})
class UserInfoRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetUserInfo() {
        webTestClient.get()
                .uri("/user/1")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World");
    }

}