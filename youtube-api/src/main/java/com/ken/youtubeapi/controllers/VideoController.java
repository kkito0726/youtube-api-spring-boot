package com.ken.youtubeapi.controllers;

import com.ken.youtubeapi.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = VideoController.BASE_URL)
@RequiredArgsConstructor
public class VideoController {

  private static final String BASE_URL = "/api";
  private final VideoService videoService;

  @GetMapping("/search")
  public ResponseEntity<String> searchByQuery() {
    String res = videoService.serchByQuery("pokemon");
    return ResponseEntity.ok(res);
  }
}
