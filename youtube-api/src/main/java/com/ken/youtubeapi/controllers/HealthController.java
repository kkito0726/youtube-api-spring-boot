package com.ken.youtubeapi.controllers;

import com.ken.youtubeapi.models.Sample;
import com.ken.youtubeapi.services.SampleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = HealthController.BASE_URL)
@RequiredArgsConstructor
public class HealthController {

  public static final String BASE_URL = "/health";
  private final SampleService sampleService;

  @GetMapping("")
  public ResponseEntity<String> getHealth() {
    return ResponseEntity.ok("youtube-api is up and running!");
  }

  @GetMapping("/sample")
  public ResponseEntity<List<Sample>> getJson() {
    List<Sample> samples = sampleService.getSample();
    return ResponseEntity.ok(samples);
  }
}
