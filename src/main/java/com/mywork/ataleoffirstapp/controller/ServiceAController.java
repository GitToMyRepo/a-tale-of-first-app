package com.mywork.ataleoffirstapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {
    private final RestTemplate restTemplate;

    @Value("${second.service.context-path}")
    private String secondServiceContext;

    @Value("${second.service.port}")
    private int secondServicePort;

    public ServiceAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/call-service-b")
    public String callServiceB() {
        String serviceBResponse = restTemplate.getForObject("http://localhost:"+secondServicePort+"/"+secondServiceContext+"/service-b", String.class);
        return "Response from Service B: " + serviceBResponse;
    }
}
