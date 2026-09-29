package com.javaplusai.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/greetings/{name}")
    public GreetingResponse greet(@PathVariable String name) {
        return new GreetingResponse("Hello, %s!".formatted(name));
    }

    public record GreetingResponse(String message) {
    }
}
