package com.ken.youtubeapi.models;

import com.google.api.client.util.DateTime;
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
  private DateTime publishTime;
  private String description;
}
