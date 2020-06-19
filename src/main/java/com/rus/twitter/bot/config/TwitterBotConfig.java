package com.rus.twitter.bot.config;

import com.rus.twitter.bot.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterBotConfig {

    @Autowired
    ApplicationProperties properties;

    @Bean
    public Twitter twitter () {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(properties.getAPI_KEY());
        cb.setOAuthConsumerSecret(properties.getAPI_KEY_SECRET());
        cb.setOAuthAccessTokenSecret(properties.getACCESS_TOKEN_SECRET());
        cb.setOAuthAccessToken(properties.getACCESS_TOKEN());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance() ;
    }
}
