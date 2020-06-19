package com.rus.twitter.bot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ApplicationProperties {
    @Value("${twitter.auth.api-key}")
    private String API_KEY;
    @Value("${twitter.auth.api-key-secret}")
    private String API_KEY_SECRET;
    @Value("${twitter.auth.access-token}")
    private String ACCESS_TOKEN;
    @Value("${twitter.auth.access-token-secret}")
    private String ACCESS_TOKEN_SECRET;
    @Value("${bot.tweetfreq.thirty-minutes}")
    private int TWEET_TIME_THIRTY_MINUTES;
    @Value("${bot.tweetfreq.five-minutes}")
    private int TWEET_TIME_FIVE_MINUTES;
    @Value("${bot.tweetfreq.hour}")
    private int TWEET_TIME_ONE_HOUR;
    @Value("${bot.tweetfreq.four-hours}")
    private int TWEET_TIME_FOUR_HOURS;
    @Value("${bot.tweetfreq.day}")
    private int TWEET_TIME_ONE_DAY;
}
