package com.mywork.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    private final RestTemplate restTemplate;

    @Value("${second.service.context-path}")
    private String secondServiceContext;

    @Value("${second.service.port}")
    private int secondServicePort;

    @Value("${second.service.domain}")
    private String secondServiceDomain;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/greet")
    public String greet() {
        StringBuilder endpointURL = new StringBuilder();
        endpointURL.append("http://").append(this.secondServiceDomain).append(":").append(this.secondServicePort).append(secondServiceContext).append("/greet");
        System.out.println("Invoking " + endpointURL);
        String serviceBResponse = restTemplate.getForObject(endpointURL.toString(), String.class);
        return "Response from Consumer: " + serviceBResponse;
    }
}
