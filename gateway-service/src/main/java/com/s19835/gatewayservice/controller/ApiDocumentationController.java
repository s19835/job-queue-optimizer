package com.s19835.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiDocumentationController {

    @GetMapping("/api-docs")
    public Map<String, String> getApiDocumentation() {
        Map<String, String> docs = new HashMap<>();
        docs.put("jobs_endpoint", "/api/jobs - Manage job queue (POST, GET, PUT, DELETE)");
        docs.put("workers_endpoint", "/api/workers - Manage worker nodes (GET, POST)");
        docs.put("health_check", "/actuator/health - System health status");
        return docs;
    }
}
