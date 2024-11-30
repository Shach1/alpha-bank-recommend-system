package ru.hackathon.alphabank.recommendsystem.model;

public record DocumentType(
        int mobile, // Количество подписаний в мобильном приложении
        int web // Количество подписаний в вебе
) {}