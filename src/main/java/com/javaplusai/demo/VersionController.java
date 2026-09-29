package com.javaplusai.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/api/version")
    public VersionResponse version() {
        return new VersionResponse("1.0.0");
    }

    public record VersionResponse(String version) {
    }
}
