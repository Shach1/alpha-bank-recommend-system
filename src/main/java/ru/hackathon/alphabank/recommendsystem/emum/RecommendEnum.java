package ru.hackathon.alphabank.recommendsystem.emum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum RecommendEnum {
    PAY_CONTROL("PayControl"),
    KEP_TOKEN("КЭП на токене"),
    KEP_APPLICATION("КЭП на приложении");

    private final String recommendName;

    RecommendEnum(String recommendName) {
        this.recommendName = recommendName;
    }
}
