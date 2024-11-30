package ru.hackathon.alphabank.recommendsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContextData(
        @JsonProperty("context") int context
) {}