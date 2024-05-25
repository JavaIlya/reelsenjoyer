package com.javailya.reels.enjoyer.processor.handler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;

public interface UpdatesHandler {

    boolean validHandler(String message);

    void handleUpdate(Update update, TelegramBot bot);
}
