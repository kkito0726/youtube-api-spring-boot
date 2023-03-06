package com.ken.youtubeapi.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

  private String channelTitle;
  private String videoTitle;
  private String videoId;
  private String thumbnail;
  private LocalDateTime publishTime;
  private String description;
}
