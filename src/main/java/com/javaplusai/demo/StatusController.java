package com.javaplusai.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public StatusResponse status() {
        return new StatusResponse("UP", "claude-code-ecosystem-demo");
    }

    public record StatusResponse(String status, String service) {
    }
}
