package com.s19835.gatewayservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/jobs")
    public ResponseEntity<String> jobServiceFallback() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Job Service is currently unavailable. Please try again later.");
    }

    @GetMapping("/workers")
    public ResponseEntity<String> workerServiceFallback() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Worker Service is currently unavailable. Please try again later.");
    }
}
