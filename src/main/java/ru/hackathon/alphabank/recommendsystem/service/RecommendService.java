package ru.hackathon.alphabank.recommendsystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.hackathon.alphabank.recommendsystem.model.ClientData;
import ru.hackathon.alphabank.recommendsystem.model.ContextData;

@Service
public class RecommendService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendService.class);

    private final RestTemplate restTemplate;

    public RecommendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String recommend(ClientData data, ContextData contextData) {
        logger.info("Received client data: {}", data);
        logger.info("Received context data: {}", contextData);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request
        HttpEntity<ClientData> request = new HttpEntity<>(data, headers);

        // Send request and get response
        String url = "http://localhost:5000/predict";
        String recommendation = restTemplate.postForObject(url, request, String.class);

        logger.info("Received recommendation from Python server: {}", recommendation);
        return recommendation;
    }
}

