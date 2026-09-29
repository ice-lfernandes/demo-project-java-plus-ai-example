package com.javaplusai.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping("/api/echo/{message}")
    public EchoResponse echo(@PathVariable String message) {
        return new EchoResponse(message);
    }

    public record EchoResponse(String message) {
    }
}
