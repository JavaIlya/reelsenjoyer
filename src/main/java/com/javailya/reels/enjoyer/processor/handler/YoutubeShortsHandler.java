package com.javailya.reels.enjoyer.processor.handler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Service;

@Service
public class YoutubeShortsHandler implements UpdatesHandler {

    // https://youtube.com/shorts/rIpIzgLX43A?si=25oaJmoDRtOte8ic

    private static final String YOUTUBE_SHORTS_PATTERN = "https://youtube.com/shorts/";
    @Override
    public boolean validHandler(String message) {
        return message.startsWith(YOUTUBE_SHORTS_PATTERN);
    }

    @Override
    public void handleUpdate(Update update, TelegramBot bot) {

    }
}
