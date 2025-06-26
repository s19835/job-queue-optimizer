package com.s19835.gatewayservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GatewayServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testApiDocumentationEndpoint() {
        webTestClient.get().uri("/api-docs").exchange().expectStatus().isOk()
                .expectBody().jsonPath("$.jobs_endpoint").exists();
    }

    @Test
    void testFallbackEndpoint() {
        webTestClient.get().uri("/fallback/jobs").exchange().expectStatus().is5xxServerError()
                .expectBody(String.class).isEqualTo("Job Service is currently unavailable. Please try again later.");
    }

}
