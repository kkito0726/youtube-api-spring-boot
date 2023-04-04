package com.ken.youtubeapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

  private String authorName;
  private String authorProfileImageUrl;
  private String publishedAt;
  private String comment;
  private long likeCount;
  private String authorChannelUrl;
}
