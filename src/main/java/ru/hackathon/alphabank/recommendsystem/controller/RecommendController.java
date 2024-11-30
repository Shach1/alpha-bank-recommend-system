package ru.hackathon.alphabank.recommendsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hackathon.alphabank.recommendsystem.request.ClientDataRequest;
import ru.hackathon.alphabank.recommendsystem.emum.RecommendEnum;
import ru.hackathon.alphabank.recommendsystem.response.RecommendResponse;
import ru.hackathon.alphabank.recommendsystem.service.RecommendService;

@RestController
@RequestMapping("/api/v1/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @PostMapping("/get")
    public ResponseEntity<String> getRecommendation(@RequestBody ClientDataRequest clientDataRequest) {
        String recommendation = recommendService.getRecommendation(clientDataRequest);
        return ResponseEntity.ok(recommendation);
    }
}
