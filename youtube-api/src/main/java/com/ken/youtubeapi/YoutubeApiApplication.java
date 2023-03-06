package com.ken.youtubeapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoutubeApiApplication {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();
    String API_KEY = dotenv.get("API_KEY");
    System.out.println(API_KEY);

    SpringApplication.run(YoutubeApiApplication.class, args);
  }
}
