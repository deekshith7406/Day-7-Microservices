package com.oneenterprise.day5.userservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Day 7 — proves that app.message / app.environment are really coming from
 * Config Server (config-repo/USER-SERVICE*.properties), not this file.
 * Nothing about this class changes based on which profile is active — only
 * the VALUES returned change, because they're resolved externally.
 *
 * GET /config/message      -> "Hello from DEV centralized config" (dev profile)
 * GET /config/environment  -> "DEV" (dev profile), "TEST" (test profile)
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${app.message}")
    private String message;

    @Value("${app.environment}")
    private String environment;

    @GetMapping("/message")
    public String message() {
        return message;
    }

    @GetMapping("/environment")
    public String environment() {
        return environment;
    }
}
