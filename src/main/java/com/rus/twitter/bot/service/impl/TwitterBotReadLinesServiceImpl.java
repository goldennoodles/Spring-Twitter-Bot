package com.rus.twitter.bot.service.impl;

import com.rus.twitter.bot.properties.ApplicationProperties;
import com.rus.twitter.bot.service.TwitterBotMessageSender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.Charset;

@Service
@RestController
public class TwitterBotReadLinesServiceImpl {

    Logger logger = LogManager.getLogger(TwitterBotReadLinesServiceImpl.class);

    @Autowired
    ApplicationProperties properties;

    @Autowired
    TwitterBotMessageSender sendTweet;

    @GetMapping(value = "/startApp")
    public Boolean startApp () {
        logger.info("Application has been started");
        readTweet();
        return true;
    }

    public void readTweet () {
            String line;
            try {
                try (
                        InputStream fis = new ClassPathResource("/tweets.txt").getInputStream();
                        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
                        BufferedReader br = new BufferedReader(isr)
                ) {
                    while ((line = br.readLine()) != null) {
                        // Deal with the line
                        sendTweet.SendMessage(line);
                        logger.info("Tweeting: " + line + "...");

                        try {
                            System.out.println("Sleeping for 30 minutes...");
                            logger.info("Sleeping for: " + properties.getTWEET_TIME_FOUR_HOURS());
                            Thread.sleep(properties.getTWEET_TIME_FOUR_HOURS()); // Every hour
                        } catch (InterruptedException e) {
                            logger.error(e);
                        }
                    }
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
}
