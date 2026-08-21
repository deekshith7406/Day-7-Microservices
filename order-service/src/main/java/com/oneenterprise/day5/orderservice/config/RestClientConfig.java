package com.oneenterprise.day5.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Section 5 of the handbook shows the base URL hard-coded directly in this
 * bean, for simplicity. Section 11 asks you to fix that by externalizing
 * it to configuration — this bean has read it via @Value("${user.service.base-url}")
 * ever since, and that line has NOT changed since Day 5.
 *
 * What changed is WHERE that property comes from: through Day 6 it was
 * defined in this service's own application.properties; as of Day 7 it's
 * defined in config-repo/ORDER-SERVICE.properties and fetched from Config
 * Server at startup instead (see application.properties' spring.config.import).
 * This class needed zero changes for that move — which is the whole point
 * of externalizing configuration in the first place.
 */
@Configuration
public class RestClientConfig {

    @Bean
    RestClient userRestClient(@Value("${user.service.base-url}") String userServiceBaseUrl) {
        return RestClient.builder()
                .baseUrl(userServiceBaseUrl)
                .build();
    }
}
