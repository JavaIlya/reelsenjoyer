package com.javailya.reels.enjoyer.processor.handler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InstagramReelsHandler implements UpdatesHandler {

    private static final String REELS_PATTERN = "https://www.instagram.com/reel/";
    private static final String POST_PATTERN = "https://www.instagram.com/p/";
    private static final String INSTAGRAM = "instagram";
    private static final String INSTAGRAM_WITH_PREFIX = "ddinstagram";
    private static final String RESPONSE_PATERN = "%s кидає рілз %s";

    @Override
    public boolean validHandler(String message) {
        return message.contains(REELS_PATTERN)|| message.contains(POST_PATTERN);
    }

    @Override
    public void handleUpdate(Update update, TelegramBot bot) {
        Message message = update.message();
        Long chatId = message.chat().id();
        String text = message.text();
        String firstName;
        if (message.from().firstName() != null && message.from().firstName().equals("Oleksandr")) {
            firstName = "Oleg";
        } else {
            firstName = message.from().firstName();
        }

        String responseLink = text.replace(INSTAGRAM, INSTAGRAM_WITH_PREFIX);

        bot.execute(new DeleteMessage(chatId, message.messageId()));
        bot.execute(new SendMessage(chatId, String.format(RESPONSE_PATERN, firstName, responseLink)));
    }
}
