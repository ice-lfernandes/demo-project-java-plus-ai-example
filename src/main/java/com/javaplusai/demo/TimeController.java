package com.javaplusai.demo;

import java.time.Clock;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final Clock clock;

    public TimeController(Clock clock) {
        this.clock = clock;
    }

    @GetMapping("/api/time")
    public TimeResponse now() {
        return new TimeResponse(Instant.now(clock).toString());
    }

    public record TimeResponse(String now) {
    }
}
