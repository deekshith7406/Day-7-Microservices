package com.oneenterprise.day5.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Day 7 — same idea as User Service's ConfigController: proves app.message
 * and app.environment are coming from Config Server
 * (config-repo/ORDER-SERVICE*.properties), not this file.
 *
 * GET /config/message      -> "Hello from DEV centralized config (Order Service)"
 * GET /config/environment  -> "DEV" / "TEST" depending on active profile
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
