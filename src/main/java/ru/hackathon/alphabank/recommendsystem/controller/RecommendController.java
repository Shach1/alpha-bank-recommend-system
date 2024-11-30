package ru.hackathon.alphabank.recommendsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hackathon.alphabank.recommendsystem.Rodi1.ClientData;
import ru.hackathon.alphabank.recommendsystem.emum.RecommendEnum;
import ru.hackathon.alphabank.recommendsystem.response.RecommendResponse;
import ru.hackathon.alphabank.recommendsystem.service.RecommendService;

@RestController
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    private final RecommendService recommendationService;

    public RecommendController(RecommendService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public ResponseEntity<String> getRecommendation(@RequestBody ClientData clientData) {
        String recommendation = recommendationService.recommend(clientData);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/random")
    public ResponseEntity<?> getRandomRecommend() {
        return ResponseEntity.ok( new RecommendResponse(RecommendEnum.values()[(int) (Math.random() * RecommendEnum.values().length)]));
    }
}
