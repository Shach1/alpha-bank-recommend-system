package ru.hackathon.alphabank.recommendsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hackathon.alphabank.recommendsystem.model.ClientData;
import ru.hackathon.alphabank.recommendsystem.emum.RecommendEnum;
import ru.hackathon.alphabank.recommendsystem.model.ContextData;
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
    public ResponseEntity<String> getRecommendation(@RequestBody ClientData clientData, @RequestParam(defaultValue = "0") int context) {
        ContextData contextData = new ContextData(context);
        String recommendation = recommendationService.recommend(clientData, contextData);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/random")
    public ResponseEntity<?> getRandomRecommend() {
        return ResponseEntity.ok( new RecommendResponse(RecommendEnum.values()[(int) (Math.random() * RecommendEnum.values().length)]));
    }

    @PostMapping("/context") // Возможно это даже не нужно
    public ResponseEntity<String> getContext(@RequestBody ContextData contextData) {
        // Обработка данных о контексте
        int context = contextData.context();
        // Логика обработки контекста
        return ResponseEntity.ok("Context received: " + context);
    }
}
