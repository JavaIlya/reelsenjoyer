package com.javailya.reels.enjoyer.processor;

import com.javailya.reels.enjoyer.processor.handler.UpdatesHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdatesProcessor {

    private final List<UpdatesHandler> updatesHandlers;

    public void handleUpdate(Update update, TelegramBot bot) {

        for (UpdatesHandler updatesHandler : updatesHandlers) {
            if (Objects.isNull(update.message()) || Objects.isNull(update.message().text())) {
                continue;
            }
            if (updatesHandler.validHandler(update.message().text())) {
                updatesHandler.handleUpdate(update, bot);
            }
        }
    }
}
