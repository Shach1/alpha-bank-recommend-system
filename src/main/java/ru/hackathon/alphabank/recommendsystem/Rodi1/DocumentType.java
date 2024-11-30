package ru.hackathon.alphabank.recommendsystem.Rodi1;

public record DocumentType(
        int mobile, // Количество подписаний в мобильном приложении
        int web // Количество подписаний в вебе
) {}
