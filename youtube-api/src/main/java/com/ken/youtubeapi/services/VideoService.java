package com.ken.youtubeapi.services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoService {

  private final String URL = "https://www.googleapis.com/youtube/v3/search";
  Dotenv dotenv = Dotenv.load();
  String API_KEY = dotenv.get("API_KEY");

  public String serchByQuery(String query) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String url = URL + "?key={API_KEY}&q={query}";
    ResponseEntity<String> response = restTemplate.exchange(
      url,
      HttpMethod.GET,
      null,
      String.class,
      API_KEY,
      query
    );
    String body = response.getBody();

    return body;
  }
}
