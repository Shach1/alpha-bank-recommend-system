package ru.hackathon.alphabank.recommendsystem.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.hackathon.alphabank.recommendsystem.emum.RecommendEnum;

@Data
@AllArgsConstructor
public class RecommendResponse {
    private RecommendEnum recommend;
}
