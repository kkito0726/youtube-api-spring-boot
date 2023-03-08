package com.ken.youtubeapi.controllers;

import com.ken.youtubeapi.models.Video;
import com.ken.youtubeapi.services.VideoService;
import java.util.List;
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
  public ResponseEntity<List<Video>> searchByQuery() {
    List<Video> res = videoService.searchByQuery("pokemon");
    return ResponseEntity.ok(res);
  }
}
