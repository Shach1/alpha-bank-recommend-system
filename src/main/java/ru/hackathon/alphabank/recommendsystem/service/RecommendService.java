package ru.hackathon.alphabank.recommendsystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.hackathon.alphabank.recommendsystem.Rodi1.ClientData;

@Service
public class RecommendService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendService.class);

    private final RestTemplate restTemplate;

    public RecommendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String recommend(ClientData data) {
        logger.info("Received client data: {}", data);

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



//    public String recommend(ClientData data) {
//        logger.info("Received client data: {}", data);
//        // 1. Если мобильное приложение есть и много подписей через мобильный
//        if (data.mobileApp() && data.signatures().common().mobile() > data.signatures().common().web()) {
//            logger.info("Recommending 'КЭП в приложении' based on mobile app usage.");
//            return "КЭП в приложении";
//        }
//
//        // 2. Если крупный или средний бизнес, предпочтение "КЭП на токене"
//        if (data.segment().equals("Средний бизнес") || data.segment().equals("Крупный бизнес")) {
//            return "КЭП на токене";
//        }
//
//        // 3. Если малый бизнес, и мобильное приложение активно используется
//        if (data.segment().equals("Малый бизнес") && data.mobileApp()) {
//            return "PayControl";
//        }
//
//        // 4. Если подключённый метод уже удобен
//        if (data.availableMethods().contains("PayControl")) {
//            return "PayControl";
//        }
//        if (data.availableMethods().contains("КЭП на токене")) {
//            return "КЭП на токене";
//        }
//        if (data.availableMethods().contains("КЭП в приложении")) {
//            return "КЭП в приложении";
//        }
//
//        // 5. Если ничего не подходит, используем "КЭП на токене" как безопасный вариант по умолчанию
//        return "КЭП на токене";
//    }
}

