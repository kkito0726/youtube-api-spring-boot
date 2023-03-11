package com.ken.youtubeapi.controllers;

import com.ken.youtubeapi.models.Comment;
import com.ken.youtubeapi.models.Video;
import com.ken.youtubeapi.models.VideoInfo;
import com.ken.youtubeapi.services.VideoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = VideoController.BASE_URL)
@RequiredArgsConstructor
public class VideoController {

  private static final String BASE_URL = "/api";
  private final VideoService videoService;

  @GetMapping("/search/{query}")
  public ResponseEntity<List<Video>> searchByQuery(@PathVariable String query) {
    List<Video> res = videoService.searchByQuery(query);
    return ResponseEntity.ok(res);
  }

  @GetMapping("/searchByChannelUrl")
  public ResponseEntity<List<Video>> serchByChannelUrl(
    @RequestParam("channelUrl") String channelUrl
  ) {
    String channelId = videoService.findChannelId(channelUrl);
    List<Video> res = videoService.searchByChannelId(channelId);
    return ResponseEntity.ok(res);
  }

  @GetMapping("/comments")
  public ResponseEntity<List<Comment>> getComments(
    @RequestParam("videoId") String videoId
  ) {
    List<Comment> comments = videoService.getComments(videoId);
    return ResponseEntity.ok(comments);
  }

  @GetMapping("/videoInfo")
  public ResponseEntity<VideoInfo> getVideoInfo(
    @RequestParam("videoId") String videoId
  ) {
    VideoInfo videoInfo = videoService.getVideoInfo(videoId);
    return ResponseEntity.ok(videoInfo);
  }
}
