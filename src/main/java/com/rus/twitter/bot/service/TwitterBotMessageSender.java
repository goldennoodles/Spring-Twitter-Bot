package com.rus.twitter.bot.service;

import org.springframework.stereotype.Component;

@Component
public interface TwitterBotMessageSender {

    void SendMessage(String message);

}