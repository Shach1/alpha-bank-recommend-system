package ru.hackathon.alphabank.recommendsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackathon.alphabank.recommendsystem.emum.RecommendEnum;
import ru.hackathon.alphabank.recommendsystem.response.RecommendResponse;

@RestController
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    @GetMapping("/random")
    public ResponseEntity<?> getRandomRecommend() {
        return ResponseEntity.ok( new RecommendResponse(RecommendEnum.values()[(int) (Math.random() * RecommendEnum.values().length)]));
    }
}
