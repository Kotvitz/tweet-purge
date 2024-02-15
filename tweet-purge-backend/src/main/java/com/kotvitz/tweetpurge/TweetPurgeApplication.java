package com.kotvitz.tweetpurge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TweetPurgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetPurgeApplication.class, args);
    }

}
