package com.oneenterprise.day5.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The centralized configuration source. Owns no business logic — it reads
 * config-repo/ (a local git repository) and hands out properties by
 * {application name}-{profile}, e.g. "give me USER-SERVICE's dev config."
 *
 * Not to be confused with discovery-server (Day 6): that answers "where is
 * USER-SERVICE running?"; this answers "what configuration should
 * USER-SERVICE use?" — two different questions, two different servers.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
