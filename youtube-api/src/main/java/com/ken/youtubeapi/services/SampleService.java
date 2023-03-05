package com.ken.youtubeapi.services;

import com.ken.youtubeapi.models.Sample;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SampleService {

  public List<Sample> getSample() {
    String URL = "https://jsonplaceholder.typicode.com/posts";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Sample[]> response = restTemplate.getForEntity(
      URL,
      Sample[].class
    );
    Sample[] body = response.getBody();
    List<Sample> samples = Arrays.asList(body);

    return samples;
  }
}
