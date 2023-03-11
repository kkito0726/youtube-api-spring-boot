package com.ken.youtubeapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfo {

  private String channelTitle;
  private String videoTitle;
  private String thumbnails;
  private String description;
}
