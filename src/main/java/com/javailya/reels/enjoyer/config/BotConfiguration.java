package com.javailya.reels.enjoyer.config;

import com.javailya.reels.enjoyer.processor.UpdatesProcessor;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BotConfiguration {

    private final UpdatesProcessor updatesProcessor;

    @Value("${reels.enjoyer.bot.token}")
    private String token;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot telegramBot = new TelegramBot(token);

        telegramBot.setUpdatesListener(list -> {
            list.forEach(update -> updatesProcessor.handleUpdate(update, telegramBot));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

        return telegramBot;
    }
}
